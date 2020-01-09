package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.Regex;
import com.sly.plugin.validate.constraints.Size;
import lombok.Data;

/**
 * 全局属性model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class GlobalProperty extends BaseModel {
    /**
     * id int(11) NOT NULL主键 自增
     */
    @NotBlank(message = "全局属性id不能为空！", group = {"updateGlobalProperty"})
    private Integer id;
    /**
     * propertyCode varchar(32) NULL属性code
     */
    @NotBlank(message = "全局属性id不能为空！", group = {"addGlobalProperty", "updateGlobalProperty"})
    @Regex(message = "全局属性Code只能输入数字、字母_,长度为1到32个字符！", group = {"addGlobalProperty", "updateGlobalProperty"}, regexp = "^([_a-zA-Z0-9]){1,32}$")
    private String propertyCode;
    /**
     * propertyCnName varchar(240) NULL中文名称
     */
    @Size(message = "中文名称最大为240个字符！", max = 240, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String propertyCnName;
    /**
     * propertyEnName varchar(240) NULL英文名称
     */
    @Size(message = "英文名称最大为240个字符！", max = 240, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String propertyEnName;
    /**
     * propertyValue varchar(240) NULL属性值
     */
    @Size(message = "属性值最大为240个字符！", max = 240, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String propertyValue;
    /**
     * createTime varchar(24) NULL创建时间 YYMMDD HHmmss
     */
    private String createTime;
    /**
     * remark varchar(240) NULL备注
     */
    @Size(message = "备注最大为240个字符！", max = 240, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String remark;
    /**
     * isOpen tinyint(4) NULL是否启用:0.关闭 1.启用
     */
    @Regex(message = "是否启用只能是启用或关闭！",group = {"addGlobalProperty", "updateGlobalProperty"},regexp = "0|1")
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * projectKz1 varchar(32) NULL备用字段1
     */
    @Size(message = "备用字段1最大为32个字符！", max = 32, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String projectKz1;
    /**
     * projectKz2 varchar(32) NULL备用字段2
     */
    @Size(message = "备用字段2最大为32个字符！", max = 32, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String projectKz2;
    /**
     * projectKz3 varchar(32) NULL备用字段3
     */
    @Size(message = "备用字段3最大为32个字符！", max = 32, group = {"addGlobalProperty", "updateGlobalProperty"})
    private String projectKz3;
}
