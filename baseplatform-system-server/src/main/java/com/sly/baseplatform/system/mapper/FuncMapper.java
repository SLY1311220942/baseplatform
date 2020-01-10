package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sly.baseplatform.common.model.Func;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能mapper
 *
 * @author SLY
 * @time 2019/12/23
 */
public interface FuncMapper extends BaseMapper<Func> {
    /**
     * 查询用户最上层菜单
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    List<Func> findUserTopFunc(String userId);

    /**
     * 查询用户下层菜单
     *
     * @param userId
     * @param funcId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    List<Func> findUserFuncChild(@Param("userId") String userId, @Param("funcId") String funcId);

    /**
     * 查询最上层菜单
     *
     * @param
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    List<Func> findTopFunc();

    /**
     * 查询下层菜单
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    List<Func> findFuncChild(String funcId);

    /**
     * 查询全部下级菜单
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    List<Func> findAllChildFunc(String funcId);

    /**
     * 根据id查询菜单详情
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    Func findFuncById(String funcId);

    /**
     * 修改功能菜单
     *
     * @param func
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int updateFunc(Func func);

    /**
     * 逻辑删除功能菜单
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int deleteFunc(String funcId);

    /**
     * 激活功能
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    int activeFunc(String funcId);

    /**
     * 禁用功能
     *
     * @param funcId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    int disableFunc(String funcId);

    /**
     * 查询用户所有可用的功能
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/10
     */
    List<Func> findUserAllFunc(String userId);
}
