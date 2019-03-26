package com.geekcattle.mapper.app;

import com.geekcattle.core.CustomerMapper;
import com.geekcattle.model.app.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper extends CustomerMapper<User> {
}
