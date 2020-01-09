package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.model.DicCode;

import java.util.List;

/**
 * 数据字典mapper
 *
 * @author SLY
 * @time 2019/12/19
 */
public interface DicCodeMapper extends BaseMapper<DicCode> {

    /**
     * 修改数据字典
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    int updateDicCode(DicCode dicCode);

    /**
     * 删除数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    int deleteDicCode(Integer dicCodeId);

    /**
     * 激活数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    int activeDicCode(Integer dicCodeId);

    /**
     * 禁用数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    int disableDicCode(Integer dicCodeId);

    /**
     * 根据id查询数据字典
     *
     * @param dicCodeId
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    DicCode findDicCodeDetail(Integer dicCodeId);

    /**
     * 查询下级数据字典
     *
     * @param page
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    List<DicCode> findChildDicCode(Page<DicCode> page, DicCode dicCode);

    /**
     * 查询全部下级数据字典(只查询有效的)
     *
     * @param dicCode
     * @return
     * @author SLY
     * @time 2020/1/9
     */
    List<DicCode> findAllChildDicCode(String dicCode);
}
