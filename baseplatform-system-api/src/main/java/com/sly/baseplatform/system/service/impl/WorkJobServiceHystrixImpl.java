package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.WorkJob;
import com.sly.baseplatform.system.service.WorkJobService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 定时任务service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class WorkJobServiceHystrixImpl implements WorkJobService {
    @Override
    public BaseResult addWorkJob(WorkJob workJob) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult updateWorkJob(WorkJob workJob) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult deleteWorkJob(String workJobId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findWorkJobDetail(String workJobId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findWorkJobList(WorkJob workJob) {
        return new BaseResult(Status.FAILED);
    }
}
