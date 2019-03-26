package com.geekcattle.mapper.app;

import com.geekcattle.core.CustomerMapper;
import com.geekcattle.model.app.Activity;
import org.springframework.stereotype.Service;

@Service
public interface ActivityMapper  extends CustomerMapper<Activity> {
}
