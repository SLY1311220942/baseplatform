package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.DicCode;
import com.sly.baseplatform.system.mapper.DicCodeMapper;
import com.sly.baseplatform.system.service.DicCodeService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典service实现
 *
 * @author SLY
 * @time 2019/12/19
 */
@Slf4j
@RestController
public class DicCodeServiceImpl implements DicCodeService {

    @Resource
    private DicCodeMapper dicCodeMapper;

    @Override
    public BaseResult addDicCode(@RequestBody DicCode dicCode) {
        dicCodeMapper.insert(dicCode);
        return new BaseResult(Status.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateDicCode(@RequestBody DicCode dicCode) {
        dicCodeMapper.updateDicCode(dicCode);
        return new BaseResult(Status.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteDicCode(@RequestParam("dicCodeId") Integer dicCodeId) {
        dicCodeMapper.deleteDicCode(dicCodeId);
        return new BaseResult(Status.DELETE_SUCCESS);
    }

    @Override
    public BaseResult activeDicCode(@RequestParam("dicCodeId") Integer dicCodeId) {
        dicCodeMapper.activeDicCode(dicCodeId);
        return new BaseResult(Status.ACTIVE_SUCCESS);
    }

    @Override
    public BaseResult disableDicCode(@RequestParam("dicCodeId") Integer dicCodeId) {
        dicCodeMapper.disableDicCode(dicCodeId);
        return new BaseResult(Status.DISABLE_SUCCESS);
    }

    @Override
    public BaseResult findDicCodeDetail(@RequestParam("dicCodeId") Integer dicCodeId) {
        DicCode dicCode = dicCodeMapper.findDicCodeDetail(dicCodeId);
        return new BaseResult(Status.QUERY_SUCCESS, "dicCode", dicCode);
    }

    @Override
    public BaseResult findChildDicCode(@RequestBody DicCode dicCode) {
        Page<DicCode> page = new Page<>(dicCode.getStartNum(), dicCode.getPageSize());
        List<DicCode> list = dicCodeMapper.findChildDicCode(page, dicCode);
        return new BaseResult(Status.QUERY_SUCCESS, page.getTotal(), list);
    }

    @Override
    public BaseResult findAllChildDicCode(@RequestParam("dicCode") String dicCode) {
        List<DicCode> list = dicCodeMapper.findAllChildDicCode(dicCode);
        return new BaseResult(Status.QUERY_SUCCESS, "dicCodes", list);
    }
}
