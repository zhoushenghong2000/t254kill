package com.zking.killcustomer.controller;

import com.github.pagehelper.PageInfo;
import com.zking.killcommon.dto.GoodsDTO;
import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillsaveDTO;
import com.zking.killcommon.dto.PageBean;
import com.zking.killcustomer.feign.GoodsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/16 21:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/goodsCustomer")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsFeign goodsFeign;

    @PostMapping("/savegoods")
    public String saveGoods(GoodsDTO goodsDTO){
        return goodsFeign.save(goodsDTO);
    }

    @PostMapping("/del")
    public String del(Integer gid,Integer gstatus){
        return goodsFeign.del(gid,gstatus);
    }

    @RequestMapping("/listgoods")
    public String getAllgoods(GoodsDTO goodsDTO){
        return goodsFeign.getAllgoods(goodsDTO);
    }

    @RequestMapping("/createMenu")
    public String getTreeNode(){
        return goodsFeign.getTreeNode();
    }

    @RequestMapping("/goodstype")
    public String del(){
        return goodsFeign.getgoodstype();
    }


    @RequestMapping("/changeStatus")
    public String changeStatus(GoodsDTO goodsDTO){
        return goodsFeign.changeStatus(goodsDTO);
    }


    @RequestMapping("/getKillItem")
    public String getKillItem(ItemKillDTO itemKillDTO){
        return goodsFeign.getKillItem(itemKillDTO);
    }

    @RequestMapping("/saveKillItem")
    public String saveKillItem(@RequestBody ItemKillsaveDTO itemKillsaveDTO){
        return goodsFeign.saveKillItem(itemKillsaveDTO);
    }

    @RequestMapping("/getForKill")
    public String saveKillItem(){
        return goodsFeign.getForKill();
    }

    @RequestMapping("/kill")
    public String beginKill(Integer killId,Integer userId){
        return goodsFeign.beginKill(killId,userId);
    }




}
