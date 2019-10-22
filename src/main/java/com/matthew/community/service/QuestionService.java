package com.matthew.community.service;

import com.matthew.community.dto.PaginationDTO;
import com.matthew.community.dto.QuestionDTO;
import com.matthew.community.dto.QuestionQueryDTO;
import com.matthew.community.exception.CustomizeErrorCode;
import com.matthew.community.exception.CustomizeException;
import com.matthew.community.mapper.QuestionExtMapper;
import com.matthew.community.mapper.QuestionMapper;
import com.matthew.community.mapper.UserMapper;
import com.matthew.community.model.Question;
import com.matthew.community.model.QuestionExample;
import com.matthew.community.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/12 18:29
 * @Version 1.0
 */
@Service
public class QuestionService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private QuestionExtMapper questionExtMapper;

    public PaginationDTO<QuestionDTO> list(String search,Integer page, Integer size) {
        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            search = String.join("|", tags);
        }


        Integer totalPage;
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO<>();
        QuestionQueryDTO questionQueryDTO = new QuestionQueryDTO();
        questionQueryDTO.setSearch(search);
        System.out.println("6");
        Integer totalCount = questionExtMapper.countBySearch(questionQueryDTO);
        System.out.println("5");
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);
        Integer offset = page < 1 ? 0 : size * (page - 1);
        questionQueryDTO.setSize(size);
        questionQueryDTO.setPage(offset);
        System.out.println("2");
        List<Question> questions = questionExtMapper.selectBySearch(questionQueryDTO);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        System.out.println("3");

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        System.out.println("4");
        paginationDTO.setData(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO<QuestionDTO> list(Long userId, Integer page, Integer size) {
        Integer totalPage;
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO<>();
        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        Integer totalCount = Math.toIntExact(questionMapper.countByExample(example));

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);
        int offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example,new RowBounds(offset,size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);

        return paginationDTO;
    }

    public QuestionDTO getById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            question.setViewCount(0);
            question.setLikeCount(0);
            question.setCommentCount(0);
            questionMapper.insert(question);
        } else {
            //更新
            Question record = new Question();
            record.setGmtModified(System.currentTimeMillis());
            record.setTitle(question.getTitle());
            record.setDescription(question.getDescription());
            record.setTag(question.getTag());
            record.setId(question.getId());
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdEqualTo(record.getId());
            int update = questionMapper.updateByExampleSelective(record, example);
            if (update != 1) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void  incView(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.incView(question);

    }

    public List<QuestionDTO> selectRelated(QuestionDTO questionDTO) {
        if (StringUtils.isBlank(questionDTO.getTag())) {
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(questionDTO.getTag(), ",");
        String regexpTag = String.join("|", tags);
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setTag(regexpTag);

        List<Question> questionList = questionExtMapper.selectRelated(question);
        return questionList.stream().map(q -> {
            QuestionDTO question1 = new QuestionDTO();
            BeanUtils.copyProperties(q, question1);
            return question1;
        }).collect(Collectors.toList());
    }
}
