package com.sly.baseplatform.config.shiro;

import com.sly.baseplatform.common.model.Func;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ShiroRealm
 *
 * @author SLY
 * @time 2020/1/10
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private FuncService funcService;

    /**
     * 授予用户权限(每次访问受限资源时执行一次)
     *
     * @param principals
     * @return
     * @author sly
     * @time 2019年2月25日
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户
        User user = (User) principals;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取用户权限
        BaseResult result = funcService.findUserAllFuncs(user.getId());
        List<Func> funcs = result.getResultArray("funcs", Func.class);
        List<String> urls = funcs.stream().map(Func::getFuncUrl).collect(Collectors.toList());
        Set<String> permissionSet = new HashSet<>(urls);
        info.setStringPermissions(permissionSet);

        return info;

    }

    /**
     * 验证用户身份(登录时执行一次)
     *
     * @param authcToken
     * @return
     * @throws AuthenticationException
     * @author sly
     * @time 2019年2月25日
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        User user = new User();
        user.setId("test01");
        user.setUsername(username);
        user.setPassword(password);

        boolean flag = true;

        if (flag) {
            // 登录成功执行
            return new SimpleAuthenticationInfo(user, password, getName());
        }

        return null;

    }
}
