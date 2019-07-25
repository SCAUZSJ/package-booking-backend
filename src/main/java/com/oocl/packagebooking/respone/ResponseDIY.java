package com.oocl.packagebooking.respone;

public class ResponseDIY<T> {

    private int code;
    private String errorMsg;
    private T data;

    public ResponseDIY(){

    }

    public ResponseDIY(int code) {
        this.code = code;
    }

    public ResponseDIY(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseDIY(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
