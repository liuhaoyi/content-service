package com.huayun.common;


public class ServiceCode {

    public static final int SUC = 1;

    /**
     * 不被支持的操作：某些操作不受理请求参数
     */
    public static final int OPER_NOT_SUPPORT = 100;

    /**
     * 当前操作失败
     */
    public static final int OPER_FAILED = 101;

    /**
     * 没有权限对相关资源进行操作
     */
    public static final int NO_PERMISSIONS = 401;

    /**
     * 没有找到相应的数据
     */
    public static final int NO_DATA_FOUND = 404;

    public static final int GROUP_CREATED_FAILED = 600;

    public static final int GROUP_UPDATEMEMBER_FAILED = 601;

    public static final int GROUP_NOT_FOUND = 602;

    /**
     * 超过群组成员容量
     */
    public static final int GROUP_MAXUSERS = 603;

    /**
     * 超过群组容量
     */
    public static final int GROUP_MAXROOMS = 604;
}
