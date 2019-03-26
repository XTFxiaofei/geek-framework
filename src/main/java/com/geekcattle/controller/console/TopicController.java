package com.geekcattle.controller.console;

import com.geekcattle.model.app.Topic;
import com.geekcattle.service.app.TopicService;
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
@RequestMapping("/console/topic")
public class TopicController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TopicService topicService;

    @RequiresPermissions("topic:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/topic/index";
    }

    @RequiresPermissions("topic:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(Topic topic) {
        ModelMap map = new ModelMap();
        List<Topic> lists = topicService.getPageList(topic);
        map.put("pageInfo", new PageInfo<Topic>(lists));
        map.put("queryParam", topic);
        return ReturnUtil.success("加载成功", map, null);
    }

}
