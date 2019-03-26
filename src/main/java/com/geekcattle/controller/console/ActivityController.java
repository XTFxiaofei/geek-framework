package com.geekcattle.controller.console;

import com.geekcattle.model.app.Activity;
import com.geekcattle.service.app.ActivityService;
import com.geekcattle.util.ReturnUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 成员类（MemberController）
 */
@Controller
@RequestMapping("/console/activity")
public class ActivityController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActivityService activityService;

    @RequiresPermissions("activity:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/activity/index";
    }

    @RequiresPermissions("activity:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(Activity activity) {
        ModelMap map = new ModelMap();
        List<Activity> lists = activityService.getPageList(activity);
        map.put("pageInfo", new PageInfo<Activity>(lists));
        map.put("queryParam", activity);
        return ReturnUtil.success("加载成功", map, null);
    }

}
