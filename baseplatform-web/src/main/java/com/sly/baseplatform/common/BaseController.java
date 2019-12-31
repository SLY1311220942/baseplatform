package com.sly.baseplatform.common;

import com.sly.baseplatform.common.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 基础controller
 *
 * @author SLY
 * @time 2019/12/19
 */
public class BaseController {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    protected Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    /**
     * 获取当前登录用户信息
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    protected User getLoginUser() {
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return (User) authentication.getPrincipal();
            }
        }
        return null;
    }

    /**
     * 获取当前登录用户id
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    protected String getLoginUserId() {
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                User user = (User) authentication.getPrincipal();
                return user.getId();
            }
        }
        return null;
    }


}
