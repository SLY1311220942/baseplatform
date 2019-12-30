package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/func")
public class FuncController extends BaseController {

    /**
     * 去功能新增页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toFuncAdd")
    public String toFuncAdd() {
        return "system/func/func_add.html";
    }

    /**
     * 去功能管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toFuncManage")
    public String toFuncManage() {
        return "system/func/func_manage.html";
    }

    /**
     * 去功能修改页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toFuncUpdate")
    public String toFuncUpdate() {
        return "system/func/func_update.html";
    }

    /**
     * 去功能角色关系管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toFuncRoleRelation")
    public String toFuncRoleRelation() {
        return "system/func/funcRole_relation.html";
    }
}
