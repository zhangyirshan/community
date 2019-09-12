package com.matthew.community.service;

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

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
