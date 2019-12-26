package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
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
    public BaseResult findUserById(String id) {
        return new BaseResult(ResultStatus.QUERY_FAILED);
    }

    @Override
    public BaseResult findUserList(User user) {
        return new BaseResult(ResultStatus.QUERY_FAILED);
    }
}
