package com.sly.baseplatform.common.constant;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 公共常量
 *
 * @author SLY
 * @time 2019/12/31
 */
public class ComConstant {

    /**
     * 逻辑删除
     *
     * @author SLY
     * @time 2019/12/31
     */
    public static class LogicDel {
        /**
         * 逻辑删除：Y.删除
         */
        public static final String Y = "Y";

        /**
         * 逻辑删除：N.未删除
         */
        public static final String N = "N";
    }

    /**
     * 是否启用
     *
     * @author SLY
     * @time 2019/12/31
     */
    public static class IsOpen {
        /**
         * 是否启用：未启用
         */
        public static final int CLOSE = 0;

        /**
         * 是否启用：启用
         */
        public static final int OPEN = 1;
    }

    /**
     * 性别
     *
     * @author SLY
     * @time 2019/12/31
     */
    public static class Gender {
        /**
         * 性别：M.男
         */
        public static final String M = "M";

        /**
         * 性别：W.女
         */
        public static final String W = "W";
    }

    /**
     * ID
     *
     * @author SLY
     * @time 2019/12/31
     */
    public static class Id {
        /**
         * 系统超级管理员ID："1"
         */
        public static final String ADMIN_ID = "1";
    }


}
