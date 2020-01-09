package com.sly.baseplatform.common.model;


import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.*;
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
    @NotBlank(message = "数据字典id不能为空！", group = {"updateDicCode"})
    private Integer id;
    /**
     * dicCode varchar(32) NULL码值
     */
    @NotBlank(message = "数据字典码值不能为空！", group = {"addDicCode", "updateDicCode"})
    @Regex(message = "数据字典码值只能输入数字、字母_,长度为1到32个字符！", group = {"addDicCode", "updateDicCode"}, regexp = "^([_a-zA-Z0-9]){1,32}$")
    private String dicCode;
    /**
     * parentDicCode varchar(32) NULL父码值
     */
    private String parentDicCode;
    /**
     * cnName varchar(240) NULL中文名称
     */
    @Size(message = "数据字典中文名称最大为240个字符！", max = 240, group = {"addDicCode", "updateDicCode"})
    private String cnName;
    /**
     * enName varchar(240) NULL英文名称
     */
    @Size(message = "数据字典英文名称最大为240个字符！", max = 240, group = {"addDicCode", "updateDicCode"})
    private String enName;
    /**
     * value varchar(240) NULL值
     */
    @Size(message = "数据字典值最大为240个字符！", max = 240, group = {"addDicCode", "updateDicCode"})
    private String value;
    /**
     * sort tinyint(4) NULL排序
     */
    @NumRange(message = "排序范围为[0,9999]！", min = 0, max = 9999, group = {"addDicCode", "updateDicCode"})
    private Integer sort;
    /**
     * remark varchar(240) NULL备注
     */
    @Size(message = "备注最大为240个字符！", group = {"addDicCode", "updateDicCode"})
    private String remark;
    /**
     * isOpen tinyint(4) NULL是否启用:0.关闭 1.启用
     */
    @Regex(message = "是否启用只能是启用或未启用！", group = {"addDicCode", "updateDicCode"}, regexp = "0|1")
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * projectKz1 varchar(32) NULL备用字段1
     */
    @Size(message = "备用字段1最大为32个字符！", max = 32, group = {"addDicCode", "updateDicCode"})
    private String projectKz1;
    /**
     * projectKz2 varchar(32) NULL备用字段2
     */
    @Size(message = "备用字段2最大为32个字符！", max = 32, group = {"addDicCode", "updateDicCode"})
    private String projectKz2;
    /**
     * projectKz3 varchar(32) NULL备用字段3
     */
    @Size(message = "备用字段3最大为32个字符！", max = 32, group = {"addDicCode", "updateDicCode"})
    private String projectKz3;
}
