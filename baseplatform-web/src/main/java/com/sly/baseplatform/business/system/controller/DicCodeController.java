package com.sly.baseplatform.business.system.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.DicCode;
import com.sly.baseplatform.system.service.DicCodeService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.annotation.Valid;
import com.sly.plugin.validate.annotation.Validate;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 数据字典controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/dicCode")
public class DicCodeController extends BaseController {

    @Resource
    private DicCodeService dicCodeService;

    /**
     * 去数据字典管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toDicCodeManage")
    public String toDicCodeManage() {
        return "system/dicCode/dicCode_manage.html";
    }

    /**
     * 去数据字典新增页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toDicCodeAdd")
    public String toDicCodeAdd() {
        return "system/dicCode/dicCode_add.html";
    }

    /**
     * 去数据字典修改页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toDicCodeUpdate")
    public String toDicCodeUpdate() {
        return "system/dicCode/dicCode_update.html";
    }

    /**
     * 新增数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @Validate
    @ResponseBody
    @RequestMapping("/addDicCode")
    @RequiresPermissions("/addDicCode")
    public BaseResult addDicCode(@Valid("addDicCode") DicCode dicCode) {
        try {
            return dicCodeService.addDicCode(dicCode);
        } catch (Exception e) {
            log.error("新增数据字典异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.SAVE_FAILED);
        }
    }

    /**
     * 修改数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateDicCode")
    @RequiresPermissions("/updateDicCode")
    public BaseResult updateDicCode(@Valid("updateDicCode") DicCode dicCode) {
        try {
            return dicCodeService.updateDicCode(dicCode);
        } catch (Exception e) {
            log.error("修改数据字典异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.UPDATE_FAILED);
        }
    }

    /**
     * 删除数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @Validate
    @ResponseBody
    @RequestMapping("/deleteDicCode")
    @RequiresPermissions("/deleteDicCode")
    public BaseResult deleteDicCode(@NotNull(message = "数据字典id不能为空！") Integer dicCodeId) {
        try {
            return dicCodeService.deleteDicCode(dicCodeId);
        } catch (Exception e) {
            log.error("删除数据字典异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DELETE_FAILED);
        }
    }

    /**
     * 激活数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @Validate
    @ResponseBody
    @RequestMapping("/activeDicCode")
    @RequiresPermissions("/activeDicCode")
    public BaseResult activeDicCode(@NotNull(message = "数据字典id不能为空！") Integer dicCodeId) {
        try {
            return dicCodeService.activeDicCode(dicCodeId);
        } catch (Exception e) {
            log.error("激活数据字典异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.ACTIVE_FAILED);
        }
    }

    /**
     * 禁用数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @Validate
    @ResponseBody
    @RequestMapping("/disableDicCode")
    @RequiresPermissions("/disableDicCode")
    public BaseResult disableDicCode(@NotNull(message = "数据字典id不能为空！") Integer dicCodeId) {
        try {
            return dicCodeService.disableDicCode(dicCodeId);
        } catch (Exception e) {
            log.error("禁用数据字典异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.FORBID_FAILED);
        }
    }

    /**
     * 查询数据字典详情
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findDicCodeDetail")
    public BaseResult findDicCodeDetail(@NotNull(message = "数据字典id不能为空！") Integer dicCodeId) {
        try {
            return dicCodeService.findDicCodeDetail(dicCodeId);
        } catch (Exception e) {
            log.error("查询数据字典详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

    /**
     * 查询下级数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @ResponseBody
    @RequestMapping("/findChildDicCode")
    public BaseResult findChildDicCode(DicCode dicCode) {
        try {
            return dicCodeService.findChildDicCode(dicCode);
        } catch (Exception e) {
            log.error("查询下级数据字典异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

    /**
     * 查询全部下级数据字典(只查询有效的)
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @ResponseBody
    @RequestMapping("/findAllChildDicCode")
    public BaseResult findAllChildDicCode(@NotNull(message = "数据字典id不能为空！") String dicCode) {
        try {
            return dicCodeService.findAllChildDicCode(dicCode);
        } catch (Exception e) {
            log.error("查询全部下级数据字典(只查询有效的)异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

}
