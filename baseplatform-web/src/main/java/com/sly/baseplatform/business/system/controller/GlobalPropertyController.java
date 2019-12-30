package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 全局属性controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/globalProperty")
public class GlobalPropertyController extends BaseController {

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
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toGlobalPropertyDetail")
    public String toGlobalPropertyDetail() {
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
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toGlobalPropertyUpdate")
    public String toGlobalPropertyUpdate() {
        return "system/globalProperty/globalProperty_update.html";
    }
}
