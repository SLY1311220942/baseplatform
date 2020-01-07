package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.Role;
import com.sly.baseplatform.system.service.RoleService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 角色service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class RoleServiceHystrixImpl implements RoleService {

    @Override
    public BaseResult addRole(Role role) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult updateRole(Role role) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult deleteRole(String roleId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult activeRole(String roleId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult disableRole(String roleId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findRoleDetail(String roleId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findRoleList(Role role) {
        return new BaseResult(Status.FAILED);
    }
}
