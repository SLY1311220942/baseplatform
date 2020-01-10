package com.sly.baseplatform.system.service;

import com.sly.baseplatform.common.model.Func;
import com.sly.baseplatform.system.service.impl.FuncServiceHystrixImpl;
import com.sly.plugin.common.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能service接口
 *
 * @author SLY
 * @time 2019/12/23
 */
@FeignClient(name = "baseplatform-system-server", fallback = FuncServiceHystrixImpl.class)
public interface FuncService {

    /**
     * 获取用户全部菜单
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    @RequestMapping(value = "/func/findUserAllFunc", method = RequestMethod.POST)
    BaseResult findUserAllMenu(@RequestParam("userId") String userId);

    /**
     * 查询全部菜单
     *
     * @param
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/func/findAllMenu", method = RequestMethod.POST)
    BaseResult findAllMenu();

    /**
     * 查询全部下级菜单
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/func/findAllChildFunc", method = RequestMethod.POST)
    BaseResult findAllChildFunc(@RequestParam("funcId") String funcId);

    /**
     * 查询菜单详情
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/func/findFuncDetail", method = RequestMethod.POST)
    BaseResult findFuncDetail(@RequestParam("funcId") String funcId);

    /**
     * 新增功能
     *
     * @param func
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/func/addFunc", method = RequestMethod.POST)
    BaseResult addFunc(@RequestBody Func func);

    /**
     * 修改功能
     *
     * @param func
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/func/updateFunc", method = RequestMethod.POST)
    BaseResult updateFunc(@RequestBody Func func);

    /**
     * 删除功能
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    @RequestMapping(value = "/func/deleteFunc", method = RequestMethod.POST)
    BaseResult deleteFunc(@RequestParam("funcId") String funcId);

    /**
     * 激活功能
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/func/activeFunc", method = RequestMethod.POST)
    BaseResult activeFunc(@RequestParam("funcId") String funcId);

    /**
     * 禁用功能
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    @RequestMapping(value = "/func/disableFunc", method = RequestMethod.POST)
    BaseResult disableFunc(@RequestParam("funcId") String funcId);

    /**
     * 获取用户所有功能
     *
     * @param
     * @return
     * @author SLY
     * @time 2020/1/10
     */
    BaseResult findUserAllFuncs(@RequestParam("userId") String userId);
}
