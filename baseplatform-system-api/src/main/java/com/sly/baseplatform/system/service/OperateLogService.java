package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.OperateLogServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 操作日志service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = OperateLogServiceHystrixImpl.class)
public interface OperateLogService {
}
