package com.sly.baseplatform.business.system.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.Role;
import com.sly.baseplatform.system.service.RoleService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.annotation.Valid;
import com.sly.plugin.validate.annotation.Validate;
import com.sly.plugin.validate.constraints.NotBlank;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 角色controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    /**
     * 去角色新增页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleAdd")
    public String toRoleAdd() {
        return "system/role/role_add.html";
    }

    /**
     * 去角色详情页面
     *
     * @param request
     * @param roleId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleDetail")
    public String toRoleDetail(HttpServletRequest request, String roleId) {
        request.setAttribute("roleId", roleId);
        return "system/role/role_detail.html";
    }

    /**
     * 去角色管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleManage")
    public String toRoleManage() {
        return "system/role/role_manage.html";
    }

    /**
     * 去角色修改页面
     *
     * @param request
     * @param roleId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleUpdate")
    public String toRoleUpdate(HttpServletRequest request, String roleId) {
        request.setAttribute("roleId", roleId);
        return "system/role/role_update.html";
    }

    /**
     * 去角色功能关系管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleFuncRelation")
    public String toRoleFuncRelation() {
        return "system/role/roleFunc_relation.html";
    }

    /**
     * 去角色用户关系管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleUserRelation")
    public String toRoleUserRelation() {
        return "system/role/roleUser_relation.html";
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/addRole")
    public BaseResult addRole(@Valid("addRole") Role role) {
        try {
            return roleService.addRole(role);
        } catch (Exception e) {
            log.error("新增角色异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.SAVE_FAILED);
        }
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateRole")
    public BaseResult updateRole(@Valid("updateRole") Role role) {
        try {
            return roleService.updateRole(role);
        } catch (Exception e) {
            log.error("修改角色异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.UPDATE_FAILED);
        }
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/deleteRole")
    public BaseResult deleteRole(@NotBlank(message = "角色id不能为空！") String roleId) {
        try {
            return roleService.deleteRole(roleId);
        } catch (Exception e) {
            log.error("删除角色异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DELETE_FAILED);
        }
    }

    /**
     * 激活角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/activeRole")
    public BaseResult activeRole(@NotBlank(message = "角色id不能为空！") String roleId) {
        try {
            return roleService.activeRole(roleId);
        } catch (Exception e) {
            log.error("激活角色异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.ACTIVE_FAILED);
        }
    }

    /**
     * 禁用角色
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/3
     */
    @Validate
    @ResponseBody
    @RequestMapping("/disableRole")
    public BaseResult disableRole(@NotBlank(message = "角色id不能为空！") String roleId) {
        try {
            return roleService.disableRole(roleId);
        } catch (Exception e) {
            log.error("禁用角色异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DISABLE_FAILED);
        }
    }

    /**
     * 查询角色详情
     *
     * @param roleId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findRoleDetail")
    public BaseResult findRoleDetail(@NotBlank(message = "角色id不能为空！") String roleId) {
        try {
            return roleService.findRoleDetail(roleId);
        } catch (Exception e) {
            log.error("查询角色详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

    /**
     * 查询角色列表
     *
     * @param role
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @ResponseBody
    @RequestMapping("/findRoleList")
    public BaseResult findRoleList(Role role) {
        try {
            return roleService.findRoleList(role);
        } catch (Exception e) {
            log.error("查询角色列表异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }
}
