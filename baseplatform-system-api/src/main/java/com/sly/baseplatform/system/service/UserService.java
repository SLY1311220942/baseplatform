package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.impl.UserServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户service接口
 *
 * @author SLY
 * @time 2019/12/23
 */
@FeignClient(name = "baseplatform-system-server", fallback = UserServiceHystrixImpl.class)
public interface UserService {

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     * @author SLY
     * @time 2019/12/23
     */
    @RequestMapping(value = "/user/findUserById", method = RequestMethod.POST)
    BaseResult findUserById(String id);

    /**
     * 查询用户列表
     *
     * @param user
     * @return
     * @author SLY
     * @time 2019/12/25
     */
    @RequestMapping(value = "/user/findUserList", method = RequestMethod.POST)
    BaseResult findUserList(@RequestBody User user);
}
