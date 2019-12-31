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
     * 查询最上层菜单
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    List<Func> findTopFunc(String userId);

    /**
     * 查询下层菜单
     *
     * @param userId
     * @param funcId
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    List<Func> findUserFuncChild(@Param("userId") String userId, @Param("funcId") String funcId);
}
