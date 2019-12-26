package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.GlobalPropertyServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 全局属性service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = GlobalPropertyServiceHystrixImpl.class)
public interface GlobalPropertyService {
}
