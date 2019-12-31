package com.sly.baseplatform.system.service;

import com.sly.baseplatform.system.service.impl.FuncServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能service接口
 *
 * @author SLY
 * @time 2019/12/23
 */
@FeignClient(name = "baseplatform-system-server", fallback = FuncServiceHystrixImpl.class)
public interface FuncService {

    /**
     * 获取用户全部菜单
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    @RequestMapping(value = "/func/findUserAllFunc", method = RequestMethod.POST)
    BaseResult findUserAllFunc(@RequestParam("userId") String userId);
}
