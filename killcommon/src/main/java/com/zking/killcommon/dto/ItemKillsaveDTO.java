package com.zking.killcommon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/20 22:29
 * @Version 1.0
 */
@Data
@ToString
public class ItemKillsaveDTO {

    private Integer id;

    private Integer itemId;

    private Integer total;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Byte isActive;

    private Date createTime;

    private  String gname;

    private Float gprice;

    private List<GoodsDTO> goods;


}
