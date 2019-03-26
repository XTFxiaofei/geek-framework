package com.geekcattle.service.app;

import com.geekcattle.mapper.app.TopicMapper;
import com.geekcattle.model.app.Topic;
import com.geekcattle.util.CamelCaseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author geekcattle
 */
@Service
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> getPageList(Topic topic) {
        PageHelper.offsetPage(topic.getOffset(), topic.getLimit());
        PageHelper.orderBy(CamelCaseUtil.toUnderlineName(topic.getSort())+" "+topic.getOrder());
        return topicMapper.selectAll();
    }

    public Integer getCount(Example example){
        return topicMapper.selectCountByExample(example);
    }

    public Topic getTopic(Topic topic){
        return topicMapper.selectOne(topic);
    }

    public void insert(Topic topic){
        topicMapper.insert(topic);
    }
}
