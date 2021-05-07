package com.zking.killcommon.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 周生洪
 * @Date 2021/4/14 16:38
 * @Version 1.0
 */
@Data
@ToString
public class GoodsDTO  extends  PageBean {

    private Integer gid;

    private String gname;

    private Float gprice;

    private Integer gtype;

    private Integer gstatus;

    private Integer glib;

    private  String tname;


}
