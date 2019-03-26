package com.geekcattle.mapper.app;

import com.geekcattle.core.CustomerMapper;
import com.geekcattle.model.app.Topic;
import org.springframework.stereotype.Service;

@Service
public interface TopicMapper extends CustomerMapper<Topic> {
}
