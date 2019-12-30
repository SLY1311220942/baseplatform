package com.sly.baseplatform.business.system.controller;

import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 索引controller
 *
 * @author SLY
 * @time 2019/12/30
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    /**
     * 去首页
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toHome")
    public String toHome() {
        return "system/home.html";
    }

    /**
     * 去欢迎页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toWelcome")
    public String toWelcome() {
        return "system/welcome.html";
    }

}
