package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class GlobalProperty extends BaseModel {
    /**
     * id int(11) NOT NULL主键 自增
     */
    private Integer id;
    /**
     * propertyCode varchar(32) NULL属性code
     */
    private String propertyCode;
    /**
     * propertyCnName varchar(240) NULL中文名称
     */
    private String propertyCnName;
    /**
     * propertyEnName varchar(240) NULL英文名称
     */
    private String propertyEnName;
    /**
     * propertyValue varchar(240) NULL属性值
     */
    private String propertyValue;
    /**
     * createTime varchar(24) NULL创建时间 YYMMDD HHmmss
     */
    private String createTime;
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
