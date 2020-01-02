package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import com.sly.plugin.validate.constraints.Regex;
import com.sly.plugin.validate.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * 功能model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class Func extends BaseModel {

    /**
     * id varchar(32) NOT NULL功能id uuid
     */
    @NotBlank(message = "功能id不能为空！", group = {"updateFunc"})
    private String id;
    /**
     * userId varchar(32) NULL添加用户id
     */
    private String userId;
    /**
     * funcName varchar(32) NULL功能名称
     */
    @NotBlank(message = "功能名称不能为空！", group = {"addFunc", "updateFunc"})
    @Size(message = "功能名称最大32个字符！", group = {"addFunc", "updateFunc"})
    private String funcName;
    /**
     * funcIcon varchar(32) NULL功能图标
     */
    @Size(message = "功能图标最大32个字符！", group = {"addFunc", "updateFunc"})
    private String funcIcon;
    /**
     * funcUrl varchar(240) NULL功能url
     */
    @NotNull(message = "功能url不能为空！", group = {"addFunc", "updateFunc"})
    @Size(message = "功能url最大240个字符！", group = {"addFunc", "updateFunc"})
    private String funcUrl;
    /**
     * funcTag tinyint(4) NULL功能标签:0.菜单 1.按钮
     */
    @NotNull(message = "功能标签不能为空！", group = {"addFunc", "updateFunc"})
    @Regex(message = "功能标签只能是菜单或按钮！", group = {"addFunc", "updateFunc"}, regexp = "0|1")
    private Integer funcTag;
    /**
     * parentId varchar(32) NULL父功能id
     */
    @Size(message = "父功能id最大32个字符！", group = {"addFunc", "updateFunc"})
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
    @NotNull(message = "功能排序不能为空！", group = {"addFunc", "updateFunc"})
    private Integer funcSort;
    /**
     * isOpen tinyint(4) NULL是否启用:0.未启用 1.启用
     */
    @NotNull(message = "是否启用不能为空！", group = {"addFunc", "updateFunc"})
    @Regex(message = "是否启用只能是启用或未启用！", group = {"addFunc", "updateFunc"}, regexp = "0|1")
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * remark varchar(240) NULL备注
     */
    @Size(message = "备注最大240个字符！", group = {"addFunc", "updateFunc"})
    private String remark;
    /**
     * 扩展字段：子菜单
     */
    private List<Func> child;
}
