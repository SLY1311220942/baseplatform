package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.RoleFuncServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 角色功能关系service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = RoleFuncServiceHystrixImpl.class)
public interface RoleFuncService {
}
