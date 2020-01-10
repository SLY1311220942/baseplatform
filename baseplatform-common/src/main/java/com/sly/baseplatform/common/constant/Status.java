package com.sly.baseplatform.common.constant;

import com.sly.plugin.common.result.IStatus;

/**
 * 返回状态枚举
 *
 * @author SLY
 * @time 2020/1/6
 */
public enum Status implements IStatus {
    /**
     * 成功
     */
    SUCCESS(200, "成功！"),
    /**
     * 失败
     */
    FAILED(400, "失败！"),
    /**
     * 保存成功返回信息:"保存成功!"
     */
    SAVE_SUCCESS(200, "保存成功！"),
    /**
     * 保存失败返回信息:"保存失败!"
     */
    SAVE_FAILED(400, "保存失败！"),
    /**
     * 删除成功返回信息:"删除成功!"
     */
    DELETE_SUCCESS(200, "删除成功！"),
    /**
     * 删除失败返回信息:"删除失败!"
     */
    DELETE_FAILED(400, "删除失败！"),
    /**
     * 修改成功返回信息:"修改成功!"
     */
    UPDATE_SUCCESS(200, "修改成功！"),
    /**
     * 修改失败返回信息:"修改失败!"
     */
    UPDATE_FAILED(400, "修改失败！"),
    /**
     * 查询成功返回信息:"查询成功!"
     */
    QUERY_SUCCESS(200, "查询成功！"),
    /**
     * 查询失败返回信息:"查询失败!"
     */
    QUERY_FAILED(400, "查询失败！"),
    /**
     * 保存成功返回信息:"保存成功!"
     */
    ACTIVE_SUCCESS(200, "激活成功！"),
    /**
     * 保存失败返回信息:"保存失败!"
     */
    ACTIVE_FAILED(400, "激活失败！"),
    /**
     * 保存成功返回信息:"禁用成功!"
     */
    FORBID_SUCCESS(200, "禁用成功！"),
    /**
     * 保存失败返回信息:"禁用失败!"
     */
    FORBID_FAILED(400, "禁用失败！"),
    /**
     * 保存成功返回信息:"保存成功!"
     */
    DISABLE_SUCCESS(200, "禁用成功！"),
    /**
     * 保存失败返回信息:"保存失败!"
     */
    DISABLE_FAILED(400, "禁用失败！"),
    /**
     * 验证码错误
     */
    VERIFY_ERROR(400, "验证码错误！"),
    /**
     * 登录超时
     */
    LOGIN_OUTTIME(300, "登录超时！"),
    /**
     * 页面过期
     */
    TOKEN_OUT(300, "页面过期请刷新重试！"),
    /**
     * 参数验证通过
     */
    VALIDATE_PASSED(200, "参数验证通过！"),
    /**
     * 参数验证不通过
     */
    VALIDATE_NOPASSED(400, "参数验证不通过！"),
    /**
     * 导入成功
     */
    IMPORT_SUCCESS(200, "导入成功！"),
    /**
     * 导入失败
     */
    IMPORT_FAILED(400, "导入失败！"),
    /**
     * 用户名或密码错误
     */
    LOGIN_INFORMATION_ERROR(400, "用户名或密码错误！"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(500, "系统错误！"),
    /**
     * 登录成功
     */
    LOGIN_SUCCESS(200, "登录成功！"),
    /**
     * 登录失败
     */
    LOGIN_FAILED(400, "登录失败！"),
    ;
    private int status;
    private String message;

    private Status(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getName() {
        return name();
    }
}
