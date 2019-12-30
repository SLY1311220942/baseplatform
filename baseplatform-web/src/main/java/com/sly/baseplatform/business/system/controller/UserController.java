package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 用户controller
 *
 * @author SLY
 * @time 2019/12/24
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 去用户管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserManage")
    public String toUserManage() {
        return "system/user/user_manage.html";
    }

    /**
     * 去用户新增页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserAdd")
    public String toUserAdd() {
        return "system/user/user_add.html";
    }

    /**
     * 去用户修改页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserUpdate")
    public String toUserUpdate() {
        return "system/user/user_update.html";
    }

    /**
     * 去用户详情页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserDetail")
    public String toUserDetail() {
        return "system/user/user_detail.html";
    }

    /**
     * 去用户角色关系页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserRoleRelation")
    public String toUserRoleRelation() {
        return "system/user/userRole_relation.html";
    }

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     * @author SLY
     * @time 2019/12/24
     */
    @ResponseBody
    @RequestMapping("/findUserById")
    public BaseResult findUserById(String id) {
        try {
            return userService.findUserById(id);
        } catch (Exception e) {
            log.info("根据用户id查询用户异常[]", e);
            return new BaseResult(ResultStatus.QUERY_FAILED);
        }
    }

    /**
     * 查询用户列表
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @ResponseBody
    @RequestMapping("/findUserList")
    public BaseResult findUserList(User user) {
        try {
            return userService.findUserList(user);
        } catch (Exception e) {
            log.info("根据用户id查询用户异常[]", e);
            return new BaseResult(ResultStatus.QUERY_FAILED);
        }
    }
}
