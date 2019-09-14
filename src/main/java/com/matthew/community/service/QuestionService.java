package com.matthew.community.service;

import com.matthew.community.dto.PaginationDTO;
import com.matthew.community.dto.QuestionDTO;
import com.matthew.community.mapper.QuestionMapper;
import com.matthew.community.mapper.UserMapper;
import com.matthew.community.model.Question;
import com.matthew.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public PaginationDTO list(Integer page, Integer size) {
        //5*(i-1)
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);

        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();



        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);


        return paginationDTO;
    }
}
