package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.*;
import lombok.Data;

/**
 * 用户model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class User extends BaseModel {
    /**
     * id varchar(32) NOT NULL用户id uuid
     */
    @NotBlank(message = "用户id不能为空！", group = {"updateUser"})
    private String id;
    /**
     * username varchar(32) NULL用户名称
     */
    @NotBlank(message = "用户名称不能为空！", group = {"addUser", "updateUser"})
    @Regex(message = "用户名称只能输入中文、数字、字母_.,长度为1到32个字符！", group = {"addUser", "updateUser"}, regexp = "^([\\u4e00-\\u9fa5a-zA-Z0-9]){1,32}$")
    private String username;
    /**
     * password varchar(32) NULL密码
     */
    @NotBlank(message = "密码不能为空！", group = {"addUser"})
    @Regex(message = "密码至少包括字母、数字、特殊字符_#@.中的2种组合，长度为8到32个字符！", group = {"addUser"}, regexp = "^(?!^[0-9]+$)(?!^[a-zA-Z]+$)(?!^[_#@.]+$).{8,32}$")
    private String password;
    /**
     * nickname varchar(32) NULL用户昵称
     */
    @Regex(message = "昵称只能输入中文、数字、字母,长度为1到32个字符！", group = {"addUser", "updateUser"}, regexp = "^([\\u4e00-\\u9fa5a-zA-Z0-9]){1,32}$")
    private String nickname;
    /**
     * realname varchar(32) NULL真实姓名
     */
    @Regex(message = "真实姓名只能输入中文、数字、字母,长度为1到32个字符！", group = {"addUser", "updateUser"}, regexp = "^([\\u4e00-\\u9fa5a-zA-Z0-9]){1,32}$")
    private String realname;
    /**
     * phone varchar(32) NULL手机号
     */
    @Phone(message = "请输入正确的手机号！", group = {"addUser", "updateUser"})
    private String phone;
    /**
     * tel varchar(32) NULL座机号
     */
    @Tel(message = "请输入正确的座机号！", group = {"addUser", "updateUser"})
    private String tel;
    /**
     * email varchar(64) NULL邮箱
     */
    @Email(message = "请输入正确的邮箱格式，长度最大为64个字符！", group = {"addUser", "updateUser"})
    private String email;
    /**
     * gender char(1) NULL性别:M.男 W.女
     */
    @Regex(message = "用户性别只能为男或女！", group = {"addUser", "updateUser"}, regexp = "^M|W$")
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
    private Integer userTag = 2;
    /**
     * status tinyint(4) NULL用户状态:0.未激活 1.激活 2.封禁
     */
    @NotNull(message = "用户状态不能为空！", group = {"addUser", "updateUser"})
    @Regex(message = "请选择正确的用户状态！", group = {"addUser", "updateUser"}, regexp = "^0|1|2$")
    private Integer status = 1;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
    /**
     * remark varchar(240) NULL备注
     */
    @Size(message = "备注最大为240个字符！", max = 240, group = {"addUser", "updateUser"})
    private String remark;
}
