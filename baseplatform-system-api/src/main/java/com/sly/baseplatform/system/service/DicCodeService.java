package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.DicCodeServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 数据字典service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = DicCodeServiceHystrixImpl.class)
public interface DicCodeService {
}
