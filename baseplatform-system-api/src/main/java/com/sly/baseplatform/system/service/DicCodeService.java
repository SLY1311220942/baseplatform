package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.DicCode;
import com.sly.baseplatform.system.service.impl.DicCodeServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 数据字典service接口
 *
 * @author SLY
 * @time 2019/12/19
 */
@FeignClient(name = "baseplatform-system-server", fallback = DicCodeServiceHystrixImpl.class)
public interface DicCodeService {
    /**
     * 新增数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/addDicCode", method = RequestMethod.POST)
    BaseResult addDicCode(@RequestBody DicCode dicCode);

    /**
     * 修改数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/updateDicCode", method = RequestMethod.POST)
    BaseResult updateDicCode(@RequestBody DicCode dicCode);

    /**
     * 删除数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/deleteDicCode", method = RequestMethod.POST)
    BaseResult deleteDicCode(@RequestParam("dicCodeId") Integer dicCodeId);

    /**
     * 激活数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/activeDicCode", method = RequestMethod.POST)
    BaseResult activeDicCode(@RequestParam("dicCodeId") Integer dicCodeId);

    /**
     * 禁用数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/disableDicCode", method = RequestMethod.POST)
    BaseResult disableDicCode(@RequestParam("dicCodeId") Integer dicCodeId);

    /**
     * 查询数据字典详情
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/findDicCodeDetail", method = RequestMethod.POST)
    BaseResult findDicCodeDetail(@RequestParam("dicCodeId") Integer dicCodeId);

    /**
     * 查询下级数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/findChildDicCode", method = RequestMethod.POST)
    BaseResult findChildDicCode(@RequestBody DicCode dicCode);

    /**
     * 查询全部下级数据字典(只查询有效的)
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/dicCode/findAllChildDicCode", method = RequestMethod.POST)
    BaseResult findAllChildDicCode(@RequestParam("dicCode") String dicCode);

}
