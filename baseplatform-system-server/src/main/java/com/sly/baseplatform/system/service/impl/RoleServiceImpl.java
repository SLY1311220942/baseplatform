package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.Role;
import com.sly.baseplatform.system.mapper.RoleMapper;
import com.sly.baseplatform.system.service.RoleService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色service实现
 *
 * @author SLY
 * @time 2019/12/20
 */
@Slf4j
@RestController
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public BaseResult addRole(@RequestBody Role role) {
        roleMapper.insert(role);
        return new BaseResult(Status.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateRole(@RequestBody Role role) {
        roleMapper.updateRole(role);
        return new BaseResult(Status.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteRole(@RequestParam("roleId") String roleId) {
        roleMapper.deleteRole(roleId);
        return new BaseResult(Status.DELETE_SUCCESS);
    }

    @Override
    public BaseResult activeRole(@RequestParam("roleId") String roleId) {
        roleMapper.activeRole(roleId);
        return new BaseResult(Status.ACTIVE_SUCCESS);
    }

    @Override
    public BaseResult disableRole(@RequestParam("roleId") String roleId) {
        roleMapper.disableRole(roleId);
        return new BaseResult(Status.DISABLE_SUCCESS);
    }

    @Override
    public BaseResult findRoleDetail(@RequestParam("roleId") String roleId) {
        Role role = roleMapper.findRoleById(roleId);
        return new BaseResult(Status.QUERY_SUCCESS, "role", role);
    }

    @Override
    public BaseResult findRoleList(Role role) {
        Page<Role> page = new Page<>(role.getStartNum(), role.getPageSize());
        List<Role> list = roleMapper.findRoleList(page, role);
        return new BaseResult(Status.QUERY_SUCCESS, page.getTotal(), list);
    }
}
