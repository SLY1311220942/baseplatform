package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.model.Role;
import com.sly.baseplatform.system.mapper.RoleMapper;
import com.sly.baseplatform.system.service.RoleService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        return new BaseResult(ResultStatus.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateRole(@RequestBody Role role) {
        roleMapper.updateRole(role);
        return new BaseResult(ResultStatus.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteRole(@RequestParam("roleId") String roleId) {
        roleMapper.deleteRole(roleId);
        return new BaseResult(ResultStatus.DELETE_SUCCESS);
    }

    @Override
    public BaseResult activeRole(@RequestParam("roleId") String roleId) {
        roleMapper.activeRole(roleId);
        return new BaseResult(ResultStatus.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult disableRole(@RequestParam("roleId") String roleId) {
        roleMapper.disableRole(roleId);
        return new BaseResult(ResultStatus.UPDATE_SUCCESS);
    }
}
