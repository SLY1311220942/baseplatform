package com.sly.baseplatform.common.model;


import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * 数据字典model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class DicCode extends BaseModel {
    /**
     * id int(11) NOT NULL码表id 自增
     */
    private Integer id;
    /**
     * dicCode varchar(32) NULL码值
     */
    private String dicCode;
    /**
     * parentDicCode varchar(32) NULL父码值
     */
    private String parentDicCode;
    /**
     * cnName varchar(240) NULL中文名称
     */
    private String cnName;
    /**
     * enName varchar(240) NULL英文名称
     */
    private String enName;
    /**
     * value varchar(240) NULL值
     */
    private String value;
    /**
     * sort tinyint(4) NULL排序
     */
    private Integer sort;
    /**
     * remark varchar(240) NULL备注
     */
    private String remark;
    /**
     * isOpen tinyint(4) NULL是否启用:0.关闭 1.启用
     */
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * projectKz1 varchar(32) NULL备用字段1
     */
    private String projectKz1;
    /**
     * projectKz2 varchar(32) NULL备用字段2
     */
    private String projectKz2;
    /**
     * projectKz3 varchar(32) NULL备用字段3
     */
    private String projectKz3;
}
