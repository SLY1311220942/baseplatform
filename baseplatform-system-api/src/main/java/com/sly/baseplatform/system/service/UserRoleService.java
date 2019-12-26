package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.UserRoleServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户角色service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = UserRoleServiceHystrixImpl.class)
public interface UserRoleService {
}
