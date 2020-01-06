package com.matthew.community.schedule;

import com.matthew.community.cache.HotTagCache;
import com.matthew.community.mapper.QuestionMapper;
import com.matthew.community.model.Question;
import com.matthew.community.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/28 20:37
 * @Version 1.0
 */
@Component
@Slf4j
public class HotTagTasks {

    @Resource
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron = "0 0 1 * * *")
    public void hostTagSchedule() {
        int offset = 0;
        int limit = 20;
        log.info("hostTagSchedule start {}", dateFormat.format(new Date()));
        List<Question> list = new ArrayList<>();
        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    Integer priority = priorities.get(tag);
                    if (priority != null) {
                        priorities.put(tag, priority + 5 + question.getCommentCount());
                    }else {
                        priorities.put(tag, 5 + question.getCommentCount());
                    }
                }
            }
            offset += limit;
        }
        hotTagCache.updateTags(priorities);

        log.info("hostTagSchedule end {}", dateFormat.format(new Date()));
    }
}
