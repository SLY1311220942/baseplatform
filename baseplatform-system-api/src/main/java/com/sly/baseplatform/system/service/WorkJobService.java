package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.WorkJobServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 定时任务service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = WorkJobServiceHystrixImpl.class)
public interface WorkJobService {
}
