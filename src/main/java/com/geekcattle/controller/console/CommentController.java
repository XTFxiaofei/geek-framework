package com.geekcattle.controller.console;

import com.geekcattle.model.app.Comment;
import com.geekcattle.service.app.CommentService;
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
@RequestMapping("/console/comment")
public class CommentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;

    @RequiresPermissions("comment:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/comment/index";
    }

    @RequiresPermissions("comment:index")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(Comment comment) {
        ModelMap map = new ModelMap();
        List<Comment> lists = commentService.getPageList(comment);
        map.put("pageInfo", new PageInfo<Comment>(lists));
        map.put("queryParam", comment);
        return ReturnUtil.success("加载成功", map, null);
    }

}
