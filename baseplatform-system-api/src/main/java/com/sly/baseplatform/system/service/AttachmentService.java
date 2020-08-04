package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.AttachmentServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 附件service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = AttachmentServiceHystrixImpl.class)
public interface AttachmentService {

}
