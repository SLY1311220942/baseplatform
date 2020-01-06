package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.ComConstant;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.Func;
import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.annotation.Valid;
import com.sly.plugin.validate.annotation.Validate;
import com.sly.plugin.validate.constraints.NotBlank;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    @RequestMapping("/findUserAllMenu")
    public BaseResult findUserAllFunc() {
        try {
            if (getLoginUserId().equals(ComConstant.Id.ADMIN_ID)) {
                return funcService.findAllMenu();
            } else {
                return funcService.findUserAllMenu(getLoginUserId());
            }
        } catch (Exception e) {
            log.error("查询用户全部菜单异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }

    }

    /**
     * 查询全部下级菜单
     *
     * @param
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @ResponseBody
    @RequestMapping("/findAllChildFunc")
    public BaseResult findAllChildFunc(String funcId) {
        try {
            return funcService.findAllChildFunc(funcId);
        } catch (Exception e) {
            log.error("查询全部下级菜单异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }

    }

    /**
     * 查询菜单详情
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findFuncDetail")
    public BaseResult findFuncDetail(@NotBlank(message = "功能id不能为空！") String funcId) {
        try {
            return funcService.findFuncDetail(funcId);
        } catch (Exception e) {
            log.error("查询菜单详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }

    }

    /**
     * 新增功能
     *
     * @param func
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/addFunc")
    public BaseResult addFunc(@Valid("addFunc") Func func) {
        try {
            return funcService.addFunc(func);
        } catch (Exception e) {
            log.error("新增功能异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.SAVE_FAILED);
        }
    }

    /**
     * 修改功能
     *
     * @param func
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateFunc")
    public BaseResult updateFunc(@Valid("updateFunc") Func func) {
        try {
            return funcService.updateFunc(func);
        } catch (Exception e) {
            log.error("修改功能异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.UPDATE_FAILED);
        }
    }

    /**
     * 删除功能
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @Validate
    @ResponseBody
    @RequestMapping("/deleteFunc")
    public BaseResult deleteFunc(@NotBlank(message = "功能id不能为空！") String funcId) {
        try {
            return funcService.deleteFunc(funcId);
        } catch (Exception e) {
            log.error("删除功能异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DELETE_FAILED);
        }
    }
}
