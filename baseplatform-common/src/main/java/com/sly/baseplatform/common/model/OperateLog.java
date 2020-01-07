package com.sly.baseplatform.common.model;

import com.sly.plugin.common.constant.CommonRegex;
import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.Regex;
import lombok.Data;

/**
 * 操作认证model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class OperateLog extends BaseModel {

    /**
     * id int(11) NOT NULL操作日志主键自增
     */
    private Integer id;
    /**
     * userId varchar(32) NULL操作用户id
     */
    private String userId;
    /**
     * operatorBroswer varchar(32) NULL操作浏览器
     */
    private String operatorBroswer;
    /**
     * operatorContent text NULL操作内容
     */
    private String operatorContent;
    /**
     * operatorIP varchar(56) NULL操作ip
     */
    private String operatorIP;
    /**
     * operateModel varchar(32) NULL操作模块
     */
    private String operateModel;
    /**
     * createTime varchar(24) NULL操作时间
     */
    private String createTime;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;

    /**
     * 扩展字段：起始操作时间
     */
    @Regex(message = "请输入合法的起始时间！", group = {"findOperateLogList"}, regexp = CommonRegex.YYMMDD_REGEX)
    private String beginCreateTime;
    /**
     * 扩展字段：终止操作时间
     */
    @Regex(message = "请输入合法的终止时间！", group = {"findOperateLogList"}, regexp = CommonRegex.YYMMDD_REGEX)
    private String endCreateTime;
}
