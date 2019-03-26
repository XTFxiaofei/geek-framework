package com.geekcattle.mapper.app;

import com.geekcattle.core.CustomerMapper;
import com.geekcattle.model.app.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentMapper extends CustomerMapper<Comment> {
}
