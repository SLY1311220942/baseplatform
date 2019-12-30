package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

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
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleDetail")
    public String toRoleDetail() {
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
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toRoleUpdate")
    public String toRoleUpdate() {
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
}
