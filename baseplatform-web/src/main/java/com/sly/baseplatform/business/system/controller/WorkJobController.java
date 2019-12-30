package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定时任务controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/workJob")
public class WorkJobController extends BaseController {

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
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWorkJobDetail")
    public String toWorkJobDetail() {
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
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWorkJobUpdate")
    public String toWorkJobUpdate() {
        return "system/workJob/workJob_update.html";
    }
}
