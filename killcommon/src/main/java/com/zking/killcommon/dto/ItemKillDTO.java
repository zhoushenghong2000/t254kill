package com.zking.killcommon.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author 周生洪
 * @Date 2021/4/19 22:47
 * @Version 1.0
 */
@Data
@ToString
public class ItemKillDTO extends  PageBean {

    private Integer id;

    private Integer itemId;

    private Integer totals;

    private Date startTime;

    private Date endTime;

    private Byte isActive;

    private Date createTime;

    private  String gname;

    private Float gprice;


    private int cankill;

    private float zk;
}
