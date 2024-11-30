package com.wk.hc.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private Integer parentId;
    private String imgPath;
    private Integer sequence;
    private String status;
    private List<CategoryVO> children;
}
