package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.Role;
import com.sly.baseplatform.system.service.impl.RoleServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 角色service接口
 *
 * @author SLY
 * @time 2019/12/23
 */
@FeignClient(name = "baseplatform-system-server", fallback = RoleServiceHystrixImpl.class)
public interface RoleService {

    /**
     * 新增角色
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/role/addRole", method = RequestMethod.POST)
    BaseResult addRole(@RequestBody Role role);

    /**
     * 修改角色
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/role/updateRole", method = RequestMethod.POST)
    BaseResult updateRole(@RequestBody Role role);

    /**
     * 逻辑删除角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/role/deleteRole", method = RequestMethod.POST)
    BaseResult deleteRole(@RequestParam("roleId") String roleId);

    /**
     * 激活角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/3
     */
    @RequestMapping(value = "/role/activeRole", method = RequestMethod.POST)
    BaseResult activeRole(@RequestParam("roleId") String roleId);

    /**
     * 禁用角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/3
     */
    @RequestMapping(value = "/role/disableRole", method = RequestMethod.POST)
    BaseResult disableRole(@RequestParam("roleId") String roleId);

    /**
     * 查询角色详情
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/role/findRoleDetail", method = RequestMethod.POST)
    BaseResult findRoleDetail(@RequestParam("roleId") String roleId);

    /**
     * 查询角色列表
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/role/findRoleList", method = RequestMethod.POST)
    BaseResult findRoleList(@RequestBody Role role);
}
