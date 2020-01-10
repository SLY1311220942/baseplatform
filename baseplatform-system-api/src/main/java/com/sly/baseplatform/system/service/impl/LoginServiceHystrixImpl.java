package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.system.service.LoginService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 登录service熔断
 *
 * @author SLY
 * @time 2020/1/10
 */
@Component
public class LoginServiceHystrixImpl implements LoginService {
    @Override
    public BaseResult userLogin(String username, String password) {
        return new BaseResult(Status.FAILED);
    }
}
