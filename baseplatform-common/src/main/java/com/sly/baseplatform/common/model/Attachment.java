package com.sly.baseplatform.common.model;

import com.sly.plugin.common.model.BaseModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 附件model
 *
 * @author SLY
 * @time 2019/12/19
 */
@Data
public class Attachment extends BaseModel {
    /**
     * id varchar(32) NOT NULL主键uuid
     */
    private String id;
    /**
     * attachmentName text NULL文件名
     */
    private String attachmentName;
    /**
     * attachmentType varchar(32) NULL文件类型
     */
    private String attachmentType;
    /**
     * uploadProcess decimal(16,0) NULL上传进度
     */
    private String uploadProcess;
    /**
     * transStatus tinyint(4) NULL传输状态:0.暂停 1.开始
     */
    private Integer transStatus;
    /**
     * attachmentStatus tinyint(4) NULL文件状态:0.上传中 1.上传完成
     */
    private Integer attachmentStatus;
    /**
     * attachmentSize decimal(16,0) NULL文件大小
     */
    private BigDecimal attachmentSize;
    /**
     * attachmentMD5 varchar(32) NULL文件MD5校验码
     */
    private String attachmentMD5;
    /**
     * attachmentLocalPath text NULL文件本地位置
     */
    private String attachmentLocalPath;
    /**
     * attachmentUploadPath text NULL文件上传服务器位置
     */
    private String attachmentUploadPath;
    /**
     * deleteTime varchar(24) NULL删除时间
     */
    private String deleteTime;
    /**
     * createTime varchar(24) NULL创建时间
     */
    private String createTime;
    /**
     * userId varchar(32) NULL用户id
     */
    private String userId;
    /**
     * logicDel char(1) NULL逻辑删除:Y.删除 N.未删除
     */
    private String logicDel;
}
