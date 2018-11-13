package com.huayun.common;

public class ServiceResult {

    public static ServiceResult SUC = new ServiceResult(ServiceCode.SUC);

    private Object data;

    private int code;

    public ServiceResult() {
    }

    public ServiceResult(Object data) {

        code = ServiceCode.SUC;
        this.data = data;
    }

    public ServiceResult(int code) {

        this.code = code;
    }

    public ServiceResult(Object data, int code) {

        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
