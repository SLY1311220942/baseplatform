package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.Func;
import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
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
    public BaseResult findUserAllMenu(String userId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findAllMenu() {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findAllChildFunc(String funcId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findFuncDetail(String funcId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult addFunc(Func func) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult updateFunc(Func func) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult deleteFunc(String funcId) {
        return new BaseResult(Status.FAILED);
    }

}
