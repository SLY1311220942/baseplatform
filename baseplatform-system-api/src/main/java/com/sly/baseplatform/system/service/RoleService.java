package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.RoleServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 角色service接口
 *
 * @author SLY
 * @time 2019/12/23
 */
@FeignClient(name = "baseplatform-system-server", fallback = RoleServiceHystrixImpl.class)
public interface RoleService {
}
