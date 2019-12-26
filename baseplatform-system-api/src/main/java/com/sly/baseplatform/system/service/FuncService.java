package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.FuncServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 功能service接口
 *
 * @author SLY
 * @time 2019/12/23
 */
@FeignClient(name = "baseplatform-system-server", fallback = FuncServiceHystrixImpl.class)
public interface FuncService {
}
