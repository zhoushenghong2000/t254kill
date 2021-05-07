package com.zking.killcommon.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 周生洪
 * @Date 2021/4/23 15:06
 * @Version 1.0
 */
@Data
@ToString
public class ItemKillSuccessDTO implements Serializable {
    private String code;

    private Integer itemId;

    private Integer killId;

    private String userId;

    private Byte status;

    private Date createTime;


}
