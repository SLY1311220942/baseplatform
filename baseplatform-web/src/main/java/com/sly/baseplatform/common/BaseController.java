package com.sly.baseplatform.common;

import com.sly.baseplatform.common.model.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础controller
 *
 * @author SLY
 * @time 2019/12/19
 */
public class BaseController {
    protected Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 获取当前登录用户信息
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    protected User getLoginUser() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
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
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            return user.getId();
        }
        return null;
    }


}
