package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.model.Func;
import com.sly.baseplatform.system.mapper.FuncMapper;
import com.sly.baseplatform.system.mapper.OperateLogMapper;
import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能service实现
 *
 * @author SLY
 * @time 2019/12/20
 */
@Slf4j
@RestController
@Transactional(rollbackFor = Exception.class)
public class FuncServiceImpl implements FuncService {
    @Resource
    private FuncMapper funcMapper;
    @Resource
    private OperateLogMapper operateLogMapper;

    @Override
    public BaseResult findUserAllMenu(@RequestParam("userId") String userId) {
        List<Func> topFunc = findUserTopFunc(userId);
        for (Func func : topFunc) {
            List<Func> childFunc = findUserFuncChild(userId, func.getId());
            if (childFunc.size() > 0) {
                func.setChild(childFunc);
            }
        }
        return new BaseResult(ResultStatus.QUERY_SUCCESS, "funcs", topFunc);
    }

    @Override
    public BaseResult findAllMenu() {
        List<Func> topFunc = findTopFunc();
        for (Func func : topFunc) {
            List<Func> childFunc = findFuncChild(func.getId());
            if (childFunc.size() > 0) {
                func.setChild(childFunc);
            }
        }
        return new BaseResult(ResultStatus.QUERY_SUCCESS, "funcs", topFunc);
    }

    @Override
    public BaseResult findAllChildFunc(@RequestParam("funcId") String funcId) {
        List<Func> list = funcMapper.findAllChildFunc(funcId);
        return new BaseResult(ResultStatus.QUERY_SUCCESS, "funcs", list);
    }

    @Override
    public BaseResult findFuncDetail(@RequestParam("funcId") String funcId) {
        Func func = funcMapper.findFuncById(funcId);
        return new BaseResult(ResultStatus.QUERY_SUCCESS, "func", func);
    }

    @Override
    public BaseResult addFunc(@RequestBody Func func) {
        funcMapper.insert(func);
        return new BaseResult(ResultStatus.SAVE_SUCCESS);
    }

    @Override
    public BaseResult updateFunc(@RequestBody Func func) {
        funcMapper.updateFunc(func);
        return new BaseResult(ResultStatus.UPDATE_SUCCESS);
    }

    @Override
    public BaseResult deleteFunc(@RequestParam("funcId") String funcId) {
        funcMapper.deleteFunc(funcId);
        return new BaseResult(ResultStatus.DELETE_SUCCESS);
    }

    /**
     * 查询用户最上层菜单
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    private List<Func> findUserTopFunc(String userId) {
        return funcMapper.findUserTopFunc(userId);
    }

    /**
     * 查询用户下层菜单
     *
     * @param userId
     * @param funcId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    private List<Func> findUserFuncChild(String userId, String funcId) {
        List<Func> list = funcMapper.findUserFuncChild(userId, funcId);
        for (Func func : list) {
            List<Func> childFunc = findUserFuncChild(userId, func.getId());
            if (childFunc.size() > 0) {
                func.setChild(childFunc);
            }
        }
        return list;
    }

    /**
     * 查询最上层菜单
     *
     * @param
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    private List<Func> findTopFunc() {
        return funcMapper.findTopFunc();
    }

    /**
     * 查询下层菜单
     *
     * @param
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    private List<Func> findFuncChild(String funcId) {
        List<Func> list = funcMapper.findFuncChild(funcId);
        for (Func func : list) {
            List<Func> childFunc = findFuncChild(func.getId());
            if (childFunc.size() > 0) {
                func.setChild(childFunc);
            }
        }
        return list;
    }
}
