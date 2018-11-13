package com.huayun.common;

public class ResultObject {
    private int state;
    private Object data;

    public ResultObject() {
        this.state = MessageCode.SUCESS;
    }

    public int getState() {
        return this.state;
    }

    public ResultObject setState(int var1) {
        this.state = var1;
        return this;
    }

    public <T> T getData() {
        return (T) this.data;
    }

    public ResultObject setData(Object var1) {
        this.data = var1;
        return this;
    }

    public static ResultObject buildSucc(Object var0) {
        return build(MessageCode.SUCESS, var0);
    }

    public static ResultObject build(int var0, Object var1) {
        ResultObject var2 = new ResultObject();
        var2.setState(var0);
        var2.setData(var1);
        return var2;
    }
}