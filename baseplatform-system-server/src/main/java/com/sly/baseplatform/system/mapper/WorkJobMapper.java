package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.model.WorkJob;

import java.util.List;

/**
 * 定时任务mapper
 *
 * @author SLY
 * @time 2019/12/23
 */
public interface WorkJobMapper extends BaseMapper<WorkJob> {
    /**
     * 修改定时任务
     *
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    int updateWorkJob(WorkJob workJob);

    /**
     * 删除定时任务
     *
     * @param workJobId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    int deleteWorkJob(String workJobId);

    /**
     * 根据id查询定时任务
     *
     * @param workJobId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    WorkJob findWorkJobById(String workJobId);

    /**
     * 查询定时任务列表
     *
     * @param page
     * @param workJob
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    List<WorkJob> findWorkJobList(Page<WorkJob> page, WorkJob workJob);
}
