package com.wk.hc.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IndexCategoryVO implements Serializable {
    private Integer id;

    private String name;

    private String imgPath;

    private List<IndexCategoryVO> children;
}
