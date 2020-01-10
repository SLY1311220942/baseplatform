package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.LoginServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录service接口
 *
 * @author SLY
 * @time 2020/1/10
 */
@FeignClient(name = "baseplatform-system-server", fallback = LoginServiceHystrixImpl.class)
public interface LoginService {

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     * @author SLY
     * @time 2020/1/10
     */
    @RequestMapping(value = "/login/userLogin", method = RequestMethod.POST)
    BaseResult userLogin(@RequestParam("username") String username, @RequestParam("password") String password);
}
