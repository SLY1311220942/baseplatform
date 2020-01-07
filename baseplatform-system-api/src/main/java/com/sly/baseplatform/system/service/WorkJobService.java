package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.WorkJob;
import com.sly.baseplatform.system.service.impl.WorkJobServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定时任务service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = WorkJobServiceHystrixImpl.class)
public interface WorkJobService {
    /**
     * 新增定时任务
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/workJob/addWorkJob", method = RequestMethod.POST)
    BaseResult addWorkJob(@RequestBody WorkJob workJob);

    /**
     * 修改定时任务
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/workJob/updateWorkJob", method = RequestMethod.POST)
    BaseResult updateWorkJob(@RequestBody WorkJob workJob);

    /**
     * 删除定时任务
     *
     * @param workJobId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/workJob/deleteWorkJob", method = RequestMethod.POST)
    BaseResult deleteWorkJob(@RequestParam("workJobId") String workJobId);

    /**
     * 查询定时任务详情
     *
     * @param workJobId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/workJob/findWorkJobDetail", method = RequestMethod.POST)
    BaseResult findWorkJobDetail(@RequestParam("workJobId") String workJobId);

    /**
     * 查询定时任务列表
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/workJob/findWorkJobList", method = RequestMethod.POST)
    BaseResult findWorkJobList(@RequestBody WorkJob workJob);
}
