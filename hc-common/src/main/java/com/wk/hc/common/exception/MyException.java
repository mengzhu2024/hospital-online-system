package com.wk.hc.common.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {
    private String msg;

    public MyException() {

    }

    public MyException(String msg) {
        this.msg = msg;
    }
}
