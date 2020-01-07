package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * 用户角色关系model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class UserRole extends BaseModel {
    /**
     * id int(11) NOT NULL用户角色关系id 自增
     */
    private Integer id;
    /**
     * userId varchar(32) NULL用户id
     */
    private String userId;
    /**
     * roleId varchar(32) NULL角色id
     */
    private String roleId;
}
