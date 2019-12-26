package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

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

    @ResponseBody
    @RequestMapping("/findUserList1")
    public BaseResult findUserList(User user) {
        try {
            return userService.findUserList(user);
        } catch (Exception e) {
            log.info("根据用户id查询用户异常[]", e);
            return new BaseResult(ResultStatus.QUERY_FAILED);
        }
    }
}
