package com.wk.hc.common.vo;

import lombok.Data;

@Data
public class ResultVO {
    //默认值0表示成功
    private int code;

    //失败原因
    private String msg;

    //携带的数据
    private Object data;

    public ResultVO(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(String msg){
        this.msg = msg;
    }

    public ResultVO(){
    }
}
