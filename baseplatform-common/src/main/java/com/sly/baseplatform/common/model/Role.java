package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class Role extends BaseModel {
    /**
     * id varchar(32) NOT NULL角色id uuid
     */
    private String id;
    /**
     * userId varchar(32) NULL添加用户id
     */
    private String userId;
    /**
     * roleName varchar(32) NULL角色名称
     */
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
    private Integer isOpen;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * remark varchar(240) NULL备注
     */
    private String remark;
}
