package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.mapper.UserMapper;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
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
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public BaseResult findUserById(String id) {
        User user = userMapper.findUserById(id);
        return new BaseResult(ResultStatus.QUERY_SUCCESS, "user", user);
    }

    @Override
    public BaseResult findUserList(@RequestBody User user) {
        Page<User> page = new Page<>(user.getStartNum(), user.getPageSize());
        List<User> list = userMapper.findUserList(page, user);
        return new BaseResult(ResultStatus.QUERY_SUCCESS, page.getTotal(), list);
    }
}
