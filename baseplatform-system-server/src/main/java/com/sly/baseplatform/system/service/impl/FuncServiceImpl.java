package com.sly.baseplatform.system.service.impl;

import com.sly.baseplatform.common.model.Func;
import com.sly.baseplatform.system.mapper.FuncMapper;
import com.sly.baseplatform.system.mapper.OperateLogMapper;
import com.sly.baseplatform.system.service.FuncService;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
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
    public BaseResult findUserAllFunc(@RequestParam("userId") String userId) {
        List<Func> topFunc = findUserTopFunc(userId);
        for (Func func : topFunc) {
            List<Func> childFunc = findUserFuncChild(userId, func.getId());
            if (childFunc.size() > 0){
                func.setChild(childFunc);
            }
        }
        return new BaseResult(ResultStatus.QUERY_SUCCESS, "func", topFunc);
    }

    /**
     * 查询最上层菜单
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    private List<Func> findUserTopFunc(String userId) {
        return funcMapper.findTopFunc(userId);
    }

    /**
     * 查询下层菜单
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
}
