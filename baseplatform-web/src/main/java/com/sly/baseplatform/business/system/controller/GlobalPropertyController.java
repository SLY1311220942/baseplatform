package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.GlobalProperty;
import com.sly.baseplatform.system.service.GlobalPropertyService;
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
 * 全局属性controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/globalProperty")
public class GlobalPropertyController extends BaseController {

    @Resource
    private GlobalPropertyService globalPropertyService;

    /**
     * 去全局属性新增页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toGlobalPropertyAdd")
    public String toGlobalPropertyAdd() {
        return "system/globalProperty/globalProperty_add.html";
    }

    /**
     * 去全局属性详情页面
     *
     * @param request
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toGlobalPropertyDetail")
    public String toGlobalPropertyDetail(HttpServletRequest request, String globalPropertyId) {
        request.setAttribute("globalPropertyId", globalPropertyId);
        return "system/globalProperty/globalProperty_detail.html";
    }

    /**
     * 去全局属性管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toGlobalPropertyManage")
    public String toGlobalPropertyManage() {
        return "system/globalProperty/globalProperty_manage.html";
    }

    /**
     * 去全局属性修改页面
     *
     * @param request
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toGlobalPropertyUpdate")
    public String toGlobalPropertyUpdate(HttpServletRequest request, String globalPropertyId) {
        request.setAttribute("globalPropertyId", globalPropertyId);
        return "system/globalProperty/globalProperty_update.html";
    }

    /**
     * 新增全局属性
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/addGlobalProperty")
    public BaseResult addGlobalProperty(@Valid("addGlobalProperty") GlobalProperty globalProperty) {
        try {
            return globalPropertyService.addGlobalProperty(globalProperty);
        } catch (Exception e) {
            log.error("新增全局属性异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.SAVE_FAILED);
        }
    }

    /**
     * 修改全局属性
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateGlobalProperty")
    public BaseResult updateGlobalProperty(@Valid("updateGlobalProperty") GlobalProperty globalProperty) {
        try {
            return globalPropertyService.updateGlobalProperty(globalProperty);
        } catch (Exception e) {
            log.error("修改全局属性异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.UPDATE_FAILED);
        }
    }

    /**
     * 删除全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/deleteGlobalProperty")
    public BaseResult deleteGlobalProperty(@NotBlank(message = "全局属性id不能为空！") String globalPropertyId) {
        try {
            return globalPropertyService.deleteGlobalProperty(globalPropertyId);
        } catch (Exception e) {
            log.error("删除全局属性异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DELETE_FAILED);
        }
    }

    /**
     * 激活全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/activeGlobalProperty")
    public BaseResult activeGlobalProperty(@NotBlank(message = "全局属性id不能为空！") String globalPropertyId) {
        try {
            return globalPropertyService.activeGlobalProperty(globalPropertyId);
        } catch (Exception e) {
            log.error("激活全局属性异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.ACTIVE_FAILED);
        }
    }

    /**
     * 禁用全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/disableGlobalProperty")
    public BaseResult disableGlobalProperty(@NotBlank(message = "全局属性id不能为空！") String globalPropertyId) {
        try {
            return globalPropertyService.disableGlobalProperty(globalPropertyId);
        } catch (Exception e) {
            log.error("禁用全局属性异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DISABLE_FAILED);
        }
    }

    /**
     * 查询全局属性详情
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findGlobalPropertyDetail")
    public BaseResult findGlobalPropertyDetail(@NotBlank(message = "全局属性id不能为空！") String globalPropertyId) {
        try {
            return globalPropertyService.findGlobalPropertyDetail(globalPropertyId);
        } catch (Exception e) {
            log.error("查询全局属性详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

    /**
     * 查询全局属性列表
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @ResponseBody
    @RequestMapping("/findGlobalPropertyList")
    public BaseResult findGlobalPropertyList(GlobalProperty globalProperty) {
        try {
            return globalPropertyService.findGlobalPropertyList(globalProperty);
        } catch (Exception e) {
            log.error("查询全局属性列表异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }
}
