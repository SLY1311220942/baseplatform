package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.mapper.UserMapper;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户service实现
 *
 * @author SLY
 * @time 2019/12/20
 */
@Slf4j
@RestController
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public BaseResult findUserDetail(@RequestParam("userId") String userId) {
        User user = userMapper.findUserById(userId);
        return new BaseResult(Status.QUERY_SUCCESS, "user", user);
    }

    @Override
    public BaseResult findUserList(@RequestBody User user) {
        Page<User> page = new Page<>(user.getStartNum(), user.getPageSize());
        List<User> list = userMapper.findUserList(page, user);
        return new BaseResult(Status.QUERY_SUCCESS, page.getTotal(), list);
    }

    @Override
    public BaseResult addUser(@RequestBody User user) {
        userMapper.insert(user);
        return new BaseResult(Status.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
        return new BaseResult(Status.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteUser(@RequestParam("userId") String userId) {
        userMapper.deleteUser(userId);
        return new BaseResult(Status.DELETE_SUCCESS);
    }

    @Override
    public BaseResult activeUser(@RequestParam("userId") String userId) {
        userMapper.activeUser(userId);
        return new BaseResult(Status.ACTIVE_SUCCESS);
    }

    @Override
    public BaseResult disableUser(@RequestParam("userId") String userId) {
        userMapper.disableUser(userId);
        return new BaseResult(Status.DISABLE_SUCCESS);
    }

    @Override
    public BaseResult findUserByUsername(@RequestParam("username") String username) {
        User user = userMapper.findUserByUsername(username);
        return new BaseResult(Status.QUERY_SUCCESS, "user", user);
    }
}
