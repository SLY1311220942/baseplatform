package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.OperateLog;
import com.sly.baseplatform.system.service.OperateLogService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 操作日志service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class OperateLogServiceHystrixImpl implements OperateLogService {
    @Override
    public BaseResult findOperateLogDetail(Integer operateLogId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findOperateLogList(OperateLog operateLog) {
        return new BaseResult(Status.FAILED);
    }
}
