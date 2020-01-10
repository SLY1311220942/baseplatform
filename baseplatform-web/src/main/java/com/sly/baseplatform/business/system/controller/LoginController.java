package com.sly.baseplatform.business.system.controller;


import com.sly.baseplatform.common.BaseController;
import com.sly.baseplatform.common.constant.ComConstant;
import com.sly.baseplatform.common.constant.RsaConstant;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.system.service.LoginService;
import com.sly.baseplatform.system.service.UserService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.utils.RsaUtils;
import com.sly.plugin.validate.annotation.Validate;
import com.sly.plugin.validate.constraints.NotBlank;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

/**
 * 登录controller
 *
 * @author SLY
 * @time 2019/12/19
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private LoginService loginService;

    /**
     * 去登录页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/30
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {
        Map<String, byte[]> keyMap = RsaUtils.generateKeyBytes();

        PublicKey publicKey = RsaUtils.restorePublicKey(keyMap.get(RsaUtils.PUBLIC_KEY));
        PrivateKey privateKey = RsaUtils.restorePrivateKey(keyMap.get(RsaUtils.PRIVATE_KEY));
        request.setAttribute(RsaConstant.SessionKey.PUBLIC_KEY, Base64.encodeBase64String(publicKey.getEncoded()));
        request.getSession().setAttribute(RsaConstant.SessionKey.PRIVATE_KEY, privateKey);
        return "system/login.html";
    }


    /**
     * 用户登录
     *
     * @param request
     * @param a997d08b3 用户名
     * @param a3dcbf670 密码
     * @param a1ee97457 验证码
     * @return
     * @author SLY
     * @time 2020/1/10
     */

    @Validate
    @ResponseBody
    @RequestMapping("/userLogin")
    public BaseResult userLogin(HttpServletRequest request,
                                @NotBlank(message = "用户名不能为空！") String a997d08b3,
                                @NotBlank(message = "密码不能为空！") String a3dcbf670,
                                @NotBlank(message = "验证码不能为空！") String a1ee97457) {
        Map<String, byte[]> keyMap = RsaUtils.generateKeyBytes();
        PublicKey newPublicKey = RsaUtils.restorePublicKey(keyMap.get(RsaUtils.PUBLIC_KEY));
        PrivateKey newPrivateKey = RsaUtils.restorePrivateKey(keyMap.get(RsaUtils.PRIVATE_KEY));
        try {
            PrivateKey privateKey = (PrivateKey) request.getSession().getAttribute(RsaConstant.SessionKey.PRIVATE_KEY);
            String validate = RsaUtils.rsaDecode(privateKey, Base64.decodeBase64(a1ee97457));
            String username = RsaUtils.rsaDecode(privateKey, Base64.decodeBase64(a997d08b3));
            String password = RsaUtils.rsaDecode(privateKey, Base64.decodeBase64(a3dcbf670));

            String validateCode = (String) request.getSession().getAttribute(ComConstant.ValidateCode.LOGIN_VALIDATECODE_KEY);
            if (!validate.equals(validateCode)) {
                return new BaseResult(Status.VERIFY_ERROR);
            }
            BaseResult result = loginService.userLogin(username, password);
            if (result.getStatus() != Status.SUCCESS.getStatus()) {
                // 执行登录
                boolean rememberMe = false;
                UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
                SecurityUtils.getSubject().login(token);

                request.getSession().setAttribute(RsaConstant.SessionKey.PRIVATE_KEY, newPrivateKey);
                result.put("publicKey", newPublicKey);
            }
            return result;
        } catch (Exception e) {
            log.error("用户登录异常：{}", ExceptionUtils.getStackTrace(e));
            request.getSession().setAttribute(RsaConstant.SessionKey.PRIVATE_KEY, newPrivateKey);
            return new BaseResult(Status.LOGIN_FAILED, "publicKey", newPublicKey);
        }
    }

}
