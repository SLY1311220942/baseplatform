package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.mapper.UserMapper;
import com.sly.baseplatform.system.service.LoginService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录service实现
 *
 * @author SLY
 * @time 2020/1/10
 */
@Slf4j
@RestController
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;

    @Override
    public BaseResult userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userMapper.findUserByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return new BaseResult(Status.LOGIN_SUCCESS, "user", user);
        }
        return new BaseResult(Status.LOGIN_FAILED);
    }
}
