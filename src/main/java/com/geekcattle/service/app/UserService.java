package com.geekcattle.service.app;

import com.geekcattle.mapper.app.UserMapper;
import com.geekcattle.model.app.User;
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
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getPageList(User user) {
        PageHelper.offsetPage(user.getOffset(), user.getLimit());
        PageHelper.orderBy(CamelCaseUtil.toUnderlineName(user.getSort())+" "+user.getOrder());
        return userMapper.selectAll();
    }

    public Integer getCount(Example example){
        return userMapper.selectCountByExample(example);
    }

    public User getUser(User user){
        return userMapper.selectOne(user);
    }

    public void insert(User user){
        userMapper.insert(user);
    }
}
