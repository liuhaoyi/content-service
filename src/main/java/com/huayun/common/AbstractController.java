package com.huayun.common;


public abstract class AbstractController {

    final static ResultObject SUCCESS;

    final static ResultObject FAIL;

    final static ResultObject PARAM_ERROR;

    static {

        SUCCESS = new ResultObject();
        SUCCESS.setState(MessageCode.SUCESS);

        FAIL = new ResultObject();
        FAIL.setState(MessageCode.SYSERROR);

        PARAM_ERROR = new ResultObject();
        PARAM_ERROR.setState(MessageCode.PARAM_ERROR);
    }

    public ResultObject success(Object data) {

        if (data == null) {
            return SUCCESS;
        }

        if (data instanceof ServiceResult) {
            ServiceResult r = (ServiceResult) data;
            if (r.getCode() == MessageCode.SUCESS) {
                return new ResultObject().setData(r.getData());
            }
            return new ResultObject().setData(r.getData()).setState(MessageCode.IFIM_CODE + r.getCode());
        }

        return new ResultObject().setData(data).setState(MessageCode.SUCESS);
    }

    public ResultObject fail(int code) {

        if (code == MessageCode.SYSERROR) {
            return FAIL;
        }

        if (code == MessageCode.PARAM_ERROR) {
            return PARAM_ERROR;
        }

        return new ResultObject().setState(code);
    }

    public ResultObject fail(Object data) {

        if (data == null) {
            return FAIL;
        }

        return new ResultObject().setData(data);
    }

    public ResultObject fail(int code, Object data) {

        if (data == null) {
            return FAIL;
        }

        return new ResultObject().setData(data).setState(code);
    }
}
