package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.OperateLog;
import com.sly.baseplatform.system.service.OperateLogService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.annotation.Valid;
import com.sly.plugin.validate.annotation.Validate;
import com.sly.plugin.validate.constraints.NotNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 操作日志controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/operateLog")
public class OperateLogController extends BaseController {

    @Resource
    private OperateLogService operateLogService;

    /**
     * 去操作日志详情页面
     *
     * @param operateLogId
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toOperateLogDetail")
    public String toOperateLogDetail(HttpServletRequest request, String operateLogId) {
        request.setAttribute("operateLogId", operateLogId);
        return "system/operateLog/operateLog_detail.html";
    }

    /**
     * 去操作日志管理页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toOperateLogManage")
    public String toOperateLogManage() {
        return "system/operateLog/operateLog_manage.html";
    }

    /**
     * 查询操作日志详情
     *
     * @param operateLogId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findOperateLogDetail")
    public BaseResult findOperateLogDetail(@NotNull(message = "操作日志id不能为空！") Integer operateLogId) {
        try {
            return operateLogService.findOperateLogDetail(operateLogId);
        } catch (Exception e) {
            log.error("查询操作日志详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }

    /**
     * 查询操作日志列表
     *
     * @param operateLog
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @Validate
    @ResponseBody
    @RequestMapping("/findOperateLogList")
    public BaseResult findOperateLogList(@Valid("findOperateLogList") OperateLog operateLog) {
        try {
            return operateLogService.findOperateLogList(operateLog);
        } catch (Exception e) {
            log.error("查询操作日志详情异常：{}", ExceptionUtils.getStackTrace(e));
            return new BaseResult(Status.QUERY_FAILED);
        }
    }
}
