package cn.itsource.basic.util;

public class AjaxResult {
    private boolean success = true;
    private String msg = "";
    private Object resultObject;

    public AjaxResult() {
        this.msg = "操作成功";
    }

    public AjaxResult(String msg){
        this.success = false;
        this.msg = msg;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
