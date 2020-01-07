package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.WorkJob;
import com.sly.baseplatform.system.service.WorkJobService;
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
 * 定时任务controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/workJob")
public class WorkJobController extends BaseController {

    @Resource
    private WorkJobService workJobService;

    /**
     * 去定时任务新增页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWorkJobAdd")
    public String toWorkJobAdd() {
        return "system/workJob/workJob_add.html";
    }

    /**
     * 去定时任务详情页面
     *
     * @param request
     * @param workJobId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWorkJobDetail")
    public String toWorkJobDetail(HttpServletRequest request, String workJobId) {
        request.setAttribute("workJobId", workJobId);
        return "system/workJob/workJob_detail.html";
    }

    /**
     * 去定时任务管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWorkJobManage")
    public String toWorkJobManage() {
        return "system/workJob/workJob_manage.html";
    }

    /**
     * 去定时任务修改页面
     *
     * @param request
     * @param workJobId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWorkJobUpdate")
    public String toWorkJobUpdate(HttpServletRequest request, String workJobId) {
        request.setAttribute("workJobId", workJobId);
        return "system/workJob/workJob_update.html";
    }

    /**
     * 新增定时任务
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @Validate
    @ResponseBody
    @RequestMapping("/addWorkJob")
    public BaseResult addWorkJob(@Valid("addWorkJob") WorkJob workJob) {
        try {
            return workJobService.addWorkJob(workJob);
        } catch (Exception e) {
            log.error("新增定时任务异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.SAVE_FAILED);
        }
    }

    /**
     * 修改定时任务
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateWorkJob")
    public BaseResult updateWorkJob(@Valid("updateWorkJob") WorkJob workJob) {
        try {
            return workJobService.updateWorkJob(workJob);
        } catch (Exception e) {
            log.error("修改定时任务异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.UPDATE_FAILED);
        }
    }

    /**
     * 删除定时任务
     *
     * @param workJobId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @Validate
    @ResponseBody
    @RequestMapping("/updateWorkJob")
    public BaseResult deleteWorkJob(@NotBlank(message = "定时任务id不能为空！") String workJobId) {
        try {
            return workJobService.deleteWorkJob(workJobId);
        } catch (Exception e) {
            log.error("删除定时任务异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.DELETE_FAILED);
        }
    }

    /**
     * 查询定时任务详情
     *
     * @param workJobId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findWorkJobDetail")
    public BaseResult findWorkJobDetail(@NotBlank(message = "定时任务id不能为空！") String workJobId) {
        try {
            return workJobService.findWorkJobDetail(workJobId);
        } catch (Exception e) {
            log.error("查询定时任务详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

    /**
     * 查询定时任务列表
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @ResponseBody
    @RequestMapping("/findWorkJobList")
    public BaseResult findWorkJobList(WorkJob workJob) {
        try {
            return workJobService.findWorkJobList(workJob);
        } catch (Exception e) {
            log.error("查询定时任务列表异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }
}
