package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.impl.UserServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/23
     */
    @RequestMapping(value = "/user/findUserById", method = RequestMethod.POST)
    BaseResult findUserDetail(@RequestParam("userId") String userId);

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

    /**
     * 新增用户
     *
     * @param user
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    BaseResult addUser(@RequestBody User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
    BaseResult updateUser(@RequestBody User user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST)
    BaseResult deleteUser(@RequestParam("userId") String userId);

    /**
     * 激活用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/user/activeUser", method = RequestMethod.POST)
    BaseResult activeUser(@RequestParam("userId") String userId);

    /**
     * 禁用用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/user/disableUser", method = RequestMethod.POST)
    BaseResult disableUser(@RequestParam("userId") String userId);
}
