package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import com.sly.plugin.validate.constraints.Regex;
import com.sly.plugin.validate.constraints.Size;
import lombok.Data;

/**
 * 定时任务model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class WorkJob extends BaseModel {

    /**
     * id int(11) NOT NULL工作ID
     */
    @NotBlank(message = "定时任务id不能为空！", group = {"updateWorkJob"})
    private Integer id;
    /**
     * jobName varchar(32) NULL工作名称
     */
    @NotBlank(message = "定时任务名称不能为空！", group = {"addWorkJob", "updateWorkJob"})
    @Regex(message = "定时任务名称只能输入中文、数字、字母_.,长度为1到32个字符！", group = {"addWorkJob", "updateWorkJob"}, regexp = "^([\\u4e00-\\u9fa5_.a-zA-Z0-9]){1,32}$")
    private String jobName;
    /**
     * jobGroup varchar(32) NULL工作组
     */
    @NotBlank(message = "定时任务组名不能为空！", group = {"addWorkJob", "updateWorkJob"})
    @Regex(message = "定时任务组名只能输入数字、字母_.,长度为1到32个字符！", group = {"addWorkJob", "updateWorkJob"}, regexp = "^([_.a-zA-Z0-9]){1,32}$")
    private String jobGroup;
    /**
     * jobClass varchar(256) NULL工作类名
     */
    @NotBlank(message = "定时任务类名不能为空！", group = {"addWorkJob", "updateWorkJob"})
    @Regex(message = "定时任务类名只能输入数字、字母_.,长度为1到32个字符！", group = {"addWorkJob", "updateWorkJob"}, regexp = "^([_.a-zA-Z0-9]){1,256}$")
    private String jobClass;
    /**
     * cronExpression varchar(128) NULL表达式
     */
    @NotBlank(message = "定时任务cron表达式不能为空！", group = {"addWorkJob", "updateWorkJob"})
    @Size(message = "定时任务cron表达式不超过128位！", min = 1, max = 128, group = {"addWorkJob", "updateWorkJob"})
    private String cronExpression;
    /**
     * scheduleState smallint(6) NULL调度状态 1已启动调度 0已停止调度
     */
    @NotNull(message = "定时任务调到状态不能为空！", group = {"addWorkJob", "updateWorkJob"})
    @Regex(message = "请选择正确的调度状态！", group = {"addWorkJob", "updateWorkJob"}, regexp = "0|1")
    private Integer scheduleState;
    /**
     * createtime varchar(24) NULL创建时间
     */
    private String createtime;
    /**
     * remark varchar(240) NULL备注
     */
    @Size(message = "备注最大为240个字符！", group = {"addWorkJob", "updateWorkJob"})
    private String remark;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;


}
