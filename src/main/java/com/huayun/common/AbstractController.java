package com.huayun.common;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ResultObject pageDecorator(Page page){
        Map map = new HashMap();

        List list = page.getContent();
        Pageable pageable = page.getPageable();
        map.put("list",list);

        Map mapPage = new HashMap();
        mapPage.put("total",page.getTotalElements());
        mapPage.put("pageSize",page.getPageable().getPageSize());
        mapPage.put("current",page.getPageable().getPageNumber()+1);

        map.put("pagination",mapPage);
       return  this.success(map);
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
