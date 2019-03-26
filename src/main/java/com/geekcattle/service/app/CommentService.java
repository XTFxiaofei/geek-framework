package com.geekcattle.service.app;

import com.geekcattle.mapper.app.CommentMapper;
import com.geekcattle.model.app.Comment;
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
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getPageList(Comment comment) {
        PageHelper.offsetPage(comment.getOffset(), comment.getLimit());
        PageHelper.orderBy(CamelCaseUtil.toUnderlineName(comment.getSort())+" "+comment.getOrder());
        return commentMapper.selectAll();
    }

    public Integer getCount(Example example){
        return commentMapper.selectCountByExample(example);
    }

    public Comment getComment(Comment comment){
        return commentMapper.selectOne(comment);
    }

    public void insert(Comment comment){
        commentMapper.insert(comment);
    }
}
