package com.geekcattle.service.app;

import com.geekcattle.mapper.app.ActivityMapper;
import com.geekcattle.model.app.Activity;
import com.geekcattle.util.CamelCaseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ActivityService {

    @Autowired
    private ActivityMapper ativityMapper;

    public List<Activity> getPageList(Activity activity) {
        PageHelper.offsetPage(activity.getOffset(), activity.getLimit());
        PageHelper.orderBy(CamelCaseUtil.toUnderlineName(activity.getSort())+" "+activity.getOrder());
        return ativityMapper.selectAll();
    }

    public Integer getCount(Example example){
        return ativityMapper.selectCountByExample(example);
    }

    public Activity getActivity(Activity activity){
        return ativityMapper.selectOne(activity);
    }

    public void insert(Activity activity){
        ativityMapper.insert(activity);
    }
}
