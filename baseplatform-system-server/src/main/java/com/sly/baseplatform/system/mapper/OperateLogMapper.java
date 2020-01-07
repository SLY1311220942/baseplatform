package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.model.OperateLog;

import java.util.List;

/**
 * 操作日志mapper
 *
 * @author SLY
 * @time 2019/12/19
 */
public interface OperateLogMapper extends BaseMapper<OperateLog> {
    /**
     * 根据id查询日志详情
     *
     * @param operateLogId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    OperateLog findOperateLogById(Integer operateLogId);

    /**
     * 查询操作日志列表
     *
     * @param page
     * @param operateLog
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    List<OperateLog> findOperateLogList(Page<OperateLog> page, OperateLog operateLog);
}
