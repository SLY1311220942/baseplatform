package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据字典controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/dicCode")
public class DicCodeController extends BaseController {

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
}
