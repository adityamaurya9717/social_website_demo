package com.management.response;

public class ResponseModel<T> {

    private boolean status;

    private  Integer statusCode;

    private  T data;

    public ResponseModel(boolean status, Integer statusCode, T data) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public ResponseModel<T> setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public ResponseModel<T> setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseModel<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "status=" + status +
                ", statusCode=" + statusCode +
                ", data=" + data +
                '}';
    }
}
