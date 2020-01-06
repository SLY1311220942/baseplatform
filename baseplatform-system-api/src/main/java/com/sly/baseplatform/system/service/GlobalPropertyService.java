package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.GlobalProperty;
import com.sly.baseplatform.system.service.impl.GlobalPropertyServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 全局属性service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = GlobalPropertyServiceHystrixImpl.class)
public interface GlobalPropertyService {

    /**
     * 新增全局属性
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/addGlobalProperty", method = RequestMethod.POST)
    BaseResult addGlobalProperty(@RequestBody GlobalProperty globalProperty);

    /**
     * 修改全局属性
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/updateGlobalProperty", method = RequestMethod.POST)
    BaseResult updateGlobalProperty(@RequestBody GlobalProperty globalProperty);

    /**
     * 删除全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/deleteGlobalProperty", method = RequestMethod.POST)
    BaseResult deleteGlobalProperty(@RequestParam("globalPropertyId") String globalPropertyId);

    /**
     * 激活全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/activeGlobalProperty", method = RequestMethod.POST)
    BaseResult activeGlobalProperty(@RequestParam("globalPropertyId") String globalPropertyId);

    /**
     * 禁用全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/disableGlobalProperty", method = RequestMethod.POST)
    BaseResult disableGlobalProperty(@RequestParam("globalPropertyId") String globalPropertyId);

    /**
     * 查询全局属性详情
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/findGlobalPropertyDetail", method = RequestMethod.POST)
    BaseResult findGlobalPropertyDetail(@RequestParam("globalPropertyId") String globalPropertyId);

    /**
     * 查询全局属性列表
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    @RequestMapping(value = "/globalProperty/findGlobalPropertyList", method = RequestMethod.POST)
    BaseResult findGlobalPropertyList(@RequestBody GlobalProperty globalProperty);
}
