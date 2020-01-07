package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.WorkJob;
import com.sly.baseplatform.system.mapper.WorkJobMapper;
import com.sly.baseplatform.system.service.WorkJobService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务service实现
 *
 * @author SLY
 * @time 2019/12/20
 */
@Slf4j
@RestController
public class WorkJobServiceImpl implements WorkJobService {
    @Resource
    private WorkJobMapper workJobMapper;

    @Override
    public BaseResult addWorkJob(@RequestBody WorkJob workJob) {
        workJobMapper.insert(workJob);
        return new BaseResult(Status.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateWorkJob(@RequestBody WorkJob workJob) {
        workJobMapper.updateWorkJob(workJob);
        return new BaseResult(Status.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteWorkJob(@RequestParam("workJobId") String workJobId) {
        workJobMapper.deleteWorkJob(workJobId);
        return new BaseResult(Status.DELETE_SUCCESS);
    }

    @Override
    public BaseResult findWorkJobDetail(@RequestParam("workJobId") String workJobId) {
        WorkJob workJob = workJobMapper.findWorkJobById(workJobId);
        return new BaseResult(Status.QUERY_SUCCESS, "workJob", workJob);
    }

    @Override
    public BaseResult findWorkJobList(@RequestBody WorkJob workJob) {
        Page<WorkJob> page = new Page<>(workJob.getStartNum(), workJob.getPageSize());
        List<WorkJob> list = workJobMapper.findWorkJobList(page, workJob);
        return new BaseResult(Status.QUERY_SUCCESS, page.getTotal(), list);
    }
}
