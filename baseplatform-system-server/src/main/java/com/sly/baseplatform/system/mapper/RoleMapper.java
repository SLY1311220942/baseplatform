package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sly.baseplatform.common.model.Role;

/**
 * 角色mapper
 *
 * @author SLY
 * @time 2019/12/23
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 修改角色
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int updateRole(Role role);

    /**
     * 逻辑删除角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int deleteRole(String roleId);

    /**
     * 激活角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/3
     */
    int activeRole(String roleId);

    /**
     * 禁用角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/3
     */
    int disableRole(String roleId);

    /**
     * 根据id查询角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    Role findRoleById(String roleId);
}
