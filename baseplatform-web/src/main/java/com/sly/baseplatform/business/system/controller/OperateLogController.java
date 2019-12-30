package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 操作日志controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/operateLog")
public class OperateLogController extends BaseController {

    /**
     * 去操作日志详情页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toOperateLogDetail")
    public String toOperateLogDetail() {
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

}
