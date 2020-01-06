package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 用户service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class UserServiceHystrixImpl implements UserService {

    @Override
    public BaseResult findUserDetail(String userId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findUserList(User user) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult addUser(User user) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult updateUser(User user) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult deleteUser(String userId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult activeUser(String userId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult disableUser(String userId) {
        return new BaseResult(Status.FAILED);
    }
}
