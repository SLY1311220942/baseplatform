package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class Func extends BaseModel {

    /**
     * id varchar(32) NOT NULL功能id uuid
     */
    private String id;
    /**
     * userId varchar(32) NULL添加用户id
     */
    private String userId;
    /**
     * funcName varchar(32) NULL功能名称
     */
    private String funcName;
    /**
     * funcIcon varchar(32) NULL功能图标
     */
    private String funcIcon;
    /**
     * funcUrl varchar(240) NULL功能url
     */
    private String funcUrl;
    /**
     * funcTag tinyint(4) NULL功能标签:0.菜单 1.按钮
     */
    private Integer funcTag;
    /**
     * parentId varchar(32) NULL父功能id
     */
    private String parentId;
    /**
     * createTime varchar(24) NULL创建时间
     */
    private String createTime;
    /**
     * updateTime varchar(24) NULL修改时间
     */
    private String updateTime;
    /**
     * funcSort tinyint(4) NULL功能排序
     */
    private Integer funcSort;
    /**
     * isOpen tinyint(4) NULL是否启用:0.未启用 1.启用
     */
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * funcType tinyint(4) NULL功能类型:0.系统内置 1.普通功能
     */
    private Integer funcType;
    /**
     * remark varchar(240) NULL备注
     */
    private String remark;
}
