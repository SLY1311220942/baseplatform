package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.OperateLog;
import com.sly.baseplatform.system.service.impl.OperateLogServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 操作日志service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = OperateLogServiceHystrixImpl.class)
public interface OperateLogService {
    /**
     * 查询操作日志详情
     *
     * @param operateLogId
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/operateLog/findOperateLogDetail", method = RequestMethod.POST)
    BaseResult findOperateLogDetail(@RequestBody Integer operateLogId);

    /**
     * 查询操作日志列表
     *
     * @param operateLog
     * @return
     * @author SLY
     * @time 2020/1/7
     */
    @RequestMapping(value = "/operateLog/findOperateLogList", method = RequestMethod.POST)
    BaseResult findOperateLogList(@RequestBody OperateLog operateLog);
}
