package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.DicCode;
import com.sly.baseplatform.system.service.DicCodeService;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.stereotype.Component;

/**
 * 数据字典service熔断
 *
 * @author SLY
 * @time 2019/12/23
 */
@Component
public class DicCodeServiceHystrixImpl implements DicCodeService {

    @Override
    public BaseResult addDicCode(DicCode dicCode) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult updateDicCode(DicCode dicCode) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult deleteDicCode(Integer dicCodeId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult activeDicCode(Integer dicCodeId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult disableDicCode(Integer dicCodeId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findDicCodeDetail(Integer dicCodeId) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findChildDicCode(DicCode dicCode) {
        return new BaseResult(Status.FAILED);
    }

    @Override
    public BaseResult findAllChildDicCode(String dicCode) {
        return new BaseResult(Status.FAILED);
    }
}
