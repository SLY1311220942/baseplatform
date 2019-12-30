package com.sly.baseplatform.business.system.controller;


import com.sly.baseplatform.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录controller
 *
 * @author SLY
 * @time 2019/12/19
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    /**
     * 去登录页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "system/login.html";
    }

}
