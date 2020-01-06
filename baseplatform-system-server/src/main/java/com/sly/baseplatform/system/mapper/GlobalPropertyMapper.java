package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.model.GlobalProperty;
import com.sly.baseplatform.common.model.User;

import java.util.List;

/**
 * 全局属性mapper
 *
 * @author SLY
 * @time 2019/12/19
 */
public interface GlobalPropertyMapper extends BaseMapper<GlobalProperty> {
    /**
     * 修改全局属性
     *
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    int updateGlobalProperty(GlobalProperty globalProperty);

    /**
     * 删除全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    int deleteGlobalProperty(String globalPropertyId);

    /**
     * 激活全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    int activeGlobalProperty(String globalPropertyId);

    /**
     * 禁用全局属性
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    int disableGlobalProperty(String globalPropertyId);

    /**
     * 查询全局属性详情
     *
     * @param globalPropertyId
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    GlobalProperty findGlobalPropertyById(String globalPropertyId);

    /**
     * 查询全局属性列表
     *
     * @param page
     * @param globalProperty
     * @return
     * @author SLY
     * @time 2020/1/6
     */
    List<GlobalProperty> findGlobalPropertyList(Page<GlobalProperty> page, GlobalProperty globalProperty);
}
