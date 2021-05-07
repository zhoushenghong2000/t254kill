package com.zking.killcommon.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/15 10:43
 * @Version 1.0
 */
@Data
@ToString
public class TreeNodeDTO {
    private Integer tid;

    private String tname;

    private Integer tparent;

    private String url;

    private Integer position;

    private String icon;

    public List<TreeNodeDTO> children=new ArrayList<>();
}
