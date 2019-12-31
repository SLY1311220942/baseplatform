package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import org.springframework.stereotype.Component;

/**
 * 功能service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class FuncServiceHystrixImpl implements FuncService {

    @Override
    public BaseResult findUserAllFunc(String userId) {
        return new BaseResult(ResultStatus.QUERY_FAILED);
    }
}
