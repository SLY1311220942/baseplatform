package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import com.sly.plugin.validate.constraints.Regex;
import com.sly.plugin.validate.constraints.Size;
import lombok.Data;

/**
 * 角色model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class Role extends BaseModel {
    /**
     * id varchar(32) NOT NULL角色id uuid
     */
    @NotBlank(message = "角色id不能为空！", group = {"updateRole"})
    private String id;
    /**
     * userId varchar(32) NULL添加用户id
     */
    private String userId;
    /**
     * roleName varchar(32) NULL角色名称
     */
    @NotBlank(message = "角色名称不能为空！", group = {"addRole", "updateRole"})
    @Regex(message = "角色名称只能输入中文、数字、字母,长度为1到32个字符！", group = {"addRole", "updateRole"}, regexp = "^([\\u4e00-\\u9fa5a-zA-Z0-9]){1,32}$")
    private String roleName;
    /**
     * createTime varchar(24) NULL创建时间
     */
    private String createTime;
    /**
     * updateTime varchar(24) NULL修改时间
     */
    private String updateTime;
    /**
     * isOpen tinyint(4) NULL是否启用:0.关闭 1.启用
     */
    @NotNull(message = "是否启用不能为空！", group = {"addRole", "updateRole"})
    @Regex(message = "是否启用只能是启用或未启用！", group = {"addRole", "updateRole"}, regexp = "0|1")
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * remark varchar(240) NULL备注
     */
    @Size(message = "备注最大为240个字符！", group = {"addRole", "updateRole"})
    private String remark;
}
