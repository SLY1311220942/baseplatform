package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class User extends BaseModel {
    /**
     * id varchar(32) NOT NULL用户id uuid
     */
    private String id;
    /**
     * username varchar(32) NULL用户名称
     */
    private String username;
    /**
     * password varchar(32) NULL密码
     */
    private String password;
    /**
     * nickname varchar(32) NULL用户昵称
     */
    private String nickname;
    /**
     * realname varchar(32) NULL真实姓名
     */
    private String realname;
    /**
     * phone varchar(32) NULL手机号
     */
    private String phone;
    /**
     * tel varchar(32) NULL座机号
     */
    private String tel;
    /**
     * email varchar(64) NULL邮箱
     */
    private String email;
    /**
     * gender char(1) NULL性别:M.男 W.女
     */
    private String gender;
    /**
     * createTime varchar(24) NULL创建时间
     */
    private String createTime;
    /**
     * updateTime varchar(24) NULL更新时间
     */
    private String updateTime;
    /**
     * userTag tinyint(4) NULL用户类型:1.系统内置用户 2.普通用户
     */
    private Integer userTag;
    /**
     * status tinyint(4) NULL用户状态:0.未激活 1.激活 2.封禁
     */
    private Integer status;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * remark varchar(240) NULL备注
     */
    private String remark;
}
