package com.sly.baseplatform.common.model;


import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * 角色功能关系model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class RoleFunc extends BaseModel {
    /**
     * id int(11) NOT NULL角色功能关系id 自增
     */
    private Integer id;
    /**
     * roleId varchar(32) NULL角色id
     */
    private String roleId;
    /**
     * funcId varchar(32) NULL功能id
     */
    private String funcId;
}
