package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 功能controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/func")
public class FuncController extends BaseController {

    @Resource
    private FuncService funcService;

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

    /**
     * 查询用户全部菜单
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    @ResponseBody
    @RequestMapping("/findUserAllFunc")
    public BaseResult findUserAllFunc() {
        return funcService.findUserAllFunc(getLoginUserId());
    }
}
