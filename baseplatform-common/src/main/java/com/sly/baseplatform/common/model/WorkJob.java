package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

/**
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class WorkJob extends BaseModel {

    /**
     * id int(11) NOT NULL工作ID
     */
    private Integer id;
    /**
     * jobName varchar(32) NULL工作名称
     */
    private String jobName;
    /**
     * jobGroup varchar(32) NULL工作组
     */
    private String jobGroup;
    /**
     * jobClass varchar(256) NULL工作类名
     */
    private String jobClass;
    /**
     * cronExpression varchar(128) NULL表达式
     */
    private String cronExpression;
    /**
     * scheduleState smallint(6) NULL调度状态 1已启动调度 0已停止调度
     */
    private String scheduleState;
    /**
     * createtime varchar(24) NULL创建时间
     */
    private String createtime;
    /**
     * remark varchar(240) NULL备注
     */
    private String remark;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
}
