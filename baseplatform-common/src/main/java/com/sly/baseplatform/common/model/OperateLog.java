package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
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
}
