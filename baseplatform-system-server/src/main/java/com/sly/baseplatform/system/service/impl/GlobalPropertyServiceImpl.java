package com.sly.baseplatform.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.constant.Status;
import com.sly.baseplatform.common.model.GlobalProperty;
import com.sly.baseplatform.common.model.User;
import com.sly.baseplatform.system.mapper.GlobalPropertyMapper;
import com.sly.baseplatform.system.service.GlobalPropertyService;
import com.sly.plugin.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 全局属性service实现
 *
 * @author SLY
 * @time 2019/12/19
 */
@Slf4j
@RestController
public class GlobalPropertyServiceImpl implements GlobalPropertyService {

    @Resource
    private GlobalPropertyMapper globalPropertyMapper;

    @Override
    public BaseResult addGlobalProperty(@RequestBody GlobalProperty globalProperty) {
        globalPropertyMapper.insert(globalProperty);
        return new BaseResult(Status.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateGlobalProperty(@RequestBody GlobalProperty globalProperty) {
        globalPropertyMapper.updateGlobalProperty(globalProperty);
        return new BaseResult(Status.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteGlobalProperty(@RequestParam("globalPropertyId") String globalPropertyId) {
        globalPropertyMapper.deleteGlobalProperty(globalPropertyId);
        return new BaseResult(Status.DELETE_SUCCESS);
    }

    @Override
    public BaseResult activeGlobalProperty(@RequestParam("globalPropertyId") String globalPropertyId) {
        globalPropertyMapper.activeGlobalProperty(globalPropertyId);
        return new BaseResult(Status.ACTIVE_SUCCESS);
    }

    @Override
    public BaseResult disableGlobalProperty(@RequestParam("globalPropertyId") String globalPropertyId) {
        globalPropertyMapper.disableGlobalProperty(globalPropertyId);
        return new BaseResult(Status.DISABLE_SUCCESS);
    }

    @Override
    public BaseResult findGlobalPropertyDetail(@RequestParam("globalPropertyId") String globalPropertyId) {
        GlobalProperty globalProperty = globalPropertyMapper.findGlobalPropertyById(globalPropertyId);
        return new BaseResult(Status.QUERY_SUCCESS, "globalProperty", globalProperty);
    }

    @Override
    public BaseResult findGlobalPropertyList(@RequestBody GlobalProperty globalProperty) {
        Page<GlobalProperty> page = new Page<>(globalProperty.getStartNum(), globalProperty.getPageSize());
        List<GlobalProperty> list = globalPropertyMapper.findGlobalPropertyList(page, globalProperty);
        return new BaseResult(Status.QUERY_SUCCESS, page.getTotal(), list);
    }
}
