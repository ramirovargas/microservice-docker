package com.tanerdiler.microservice.account.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {
    private HttpStatus status;
    private Object data;
    private String error;

    public ApiResponse() {

    }

    public ApiResponse(Object data) {
        this.data = data;
        this.error = null;
    }

    public ResponseEntity<ApiResponse> send(HttpStatus status) {
        this.status = status;
        return new ResponseEntity<ApiResponse>(this, status);
    }

    public ResponseEntity<Object> send(HttpStatus status, String error) {
        this.status = status;
        this.error = error;
        return new ResponseEntity<>(this, status);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
