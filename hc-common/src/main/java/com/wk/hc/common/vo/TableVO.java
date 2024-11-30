package com.wk.hc.common.vo;


import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;
@Data
public class TableVO {
    private int code;
    private String msg;
    private Long count;
    private List data;

    public static TableVO data(List data) {
        TableVO vo = new TableVO();

        vo.setData(data);
        vo.setCount(new PageInfo<>(data).getTotal());

        return vo;
    }
}
