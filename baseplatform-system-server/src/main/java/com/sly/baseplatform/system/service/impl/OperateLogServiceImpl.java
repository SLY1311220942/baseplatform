package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.OperateLog;
import com.sly.baseplatform.system.mapper.OperateLogMapper;
import com.sly.baseplatform.system.service.OperateLogService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志service实现
 *
 * @author SLY
 * @time 2019/12/19
 */
@Slf4j
@RestController
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    private OperateLogMapper operateLogMapper;

    @Override
    public BaseResult findOperateLogDetail(Integer operateLogId) {
        OperateLog operateLog = operateLogMapper.findOperateLogById(operateLogId);
        return new BaseResult(Status.QUERY_SUCCESS, "operateLog", operateLog);
    }

    @Override
    public BaseResult findOperateLogList(OperateLog operateLog) {
        Page<OperateLog> page = new Page<>(operateLog.getStartNum(), operateLog.getPageSize());
        List<OperateLog> list = operateLogMapper.findOperateLogList(page, operateLog);
        return new BaseResult(Status.QUERY_SUCCESS, page.getTotal(), list);
    }
}
