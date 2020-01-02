package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.annotation.Valid;
import com.sly.plugin.validate.annotation.Validate;
import com.sly.plugin.validate.constraints.NotBlank;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
     * @param request
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserUpdate")
    public String toUserUpdate(HttpServletRequest request, String userId) {
        request.setAttribute("userId", userId);
        return "system/user/user_update.html";
    }

    /**
     * 去用户详情页面
     *
     * @param request
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toUserDetail")
    public String toUserDetail(HttpServletRequest request, String userId) {
        request.setAttribute("userId", userId);
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
     * 查询用户详情
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/24
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findUserDetail")
    public BaseResult findUserDetail(@NotBlank(message = "用户id不能为空！") String userId) {
        try {
            return userService.findUserDetail(userId);
        } catch (Exception e) {
            log.error("查询用户详情异常：{}", ExceptionUtils.getStackTrace(e));
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
            log.error("查询用户列表异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(ResultStatus.QUERY_FAILED);
        }
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/addUser")
    public BaseResult addUser(@Valid("addUser") User user) {
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            log.error("新增用户异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(ResultStatus.SAVE_FAILED);
        }
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateUser")
    public BaseResult updateUser(@Valid("updateUser") User user) {
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            log.error("修改用户异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(ResultStatus.UPDATE_FAILED);
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/deleteUser")
    public BaseResult deleteUser(@NotBlank(message = "用户id不能为空！") String userId) {
        try {
            return userService.deleteUser(userId);
        } catch (Exception e) {
            log.error("删除用户异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(ResultStatus.DELETE_FAILED);
        }
    }

    /**
     * 激活用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/activeUser")
    public BaseResult activeUser(@NotBlank(message = "用户id不能为空！") String userId) {
        try {
            return userService.activeUser(userId);
        } catch (Exception e) {
            log.error("激活用户异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(ResultStatus.UPDATE_FAILED);
        }
    }

    /**
     * 禁用用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/disableUser")
    public BaseResult disableUser(@NotBlank(message = "用户id不能为空！") String userId) {
        try {
            return userService.disableUser(userId);
        } catch (Exception e) {
            log.error("禁用用户异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(ResultStatus.UPDATE_FAILED);
        }
    }
}
