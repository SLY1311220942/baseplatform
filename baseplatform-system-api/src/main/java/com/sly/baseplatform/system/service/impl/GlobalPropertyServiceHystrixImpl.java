package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.GlobalProperty;
import com.sly.baseplatform.system.service.GlobalPropertyService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 全局属性service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class GlobalPropertyServiceHystrixImpl implements GlobalPropertyService {

    @Override
    public BaseResult addGlobalProperty(GlobalProperty globalProperty) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult updateGlobalProperty(GlobalProperty globalProperty) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult deleteGlobalProperty(String globalPropertyId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult activeGlobalProperty(String globalPropertyId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult disableGlobalProperty(String globalPropertyId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findGlobalPropertyDetail(String globalPropertyId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findGlobalPropertyList(GlobalProperty globalProperty) {
        return new BaseResult(Status.FAILED);
    }
}
