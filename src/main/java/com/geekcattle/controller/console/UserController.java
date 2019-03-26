package com.geekcattle.controller.console;

import com.geekcattle.model.app.User;
import com.geekcattle.model.member.Member;
import com.geekcattle.service.app.UserService;
import com.geekcattle.service.member.MemberService;
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
@RequestMapping("/console/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequiresPermissions("user:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/user/index";
    }

    @RequiresPermissions("user:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(User user) {
        ModelMap map = new ModelMap();
        List<User> lists = userService.getPageList(user);
        map.put("pageInfo", new PageInfo<User>(lists));
        map.put("queryParam", user);
        return ReturnUtil.success("加载成功", map, null);
    }

}
