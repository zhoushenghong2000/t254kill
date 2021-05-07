package com.zking.killcustomer.feign;

import com.zking.killcommon.dto.GoodsDTO;
import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillsaveDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/16 18:58
 * @Version 1.0
 */

@Component
@FeignClient("killprovider")
public interface GoodsFeign {

    @PostMapping("/goodsManager/savegoods")
    public String save(@RequestBody GoodsDTO goodsDTO);

    @PostMapping("/goodsManager/del")
    public String del(@RequestParam("gid") Integer gid,@RequestParam("gstatus") Integer gstatus);

    @RequestMapping("/goodsManager/listgoods")
    public String getAllgoods(@RequestBody GoodsDTO goodsDTO);

    @RequestMapping("/goodsManager/createMenu")
    public String getTreeNode();

    @RequestMapping("/goodsManager/goodstype")
    public String getgoodstype();


    @RequestMapping("/goodsManager/changeStatus")
    public String changeStatus(@RequestBody GoodsDTO goodsDTO);

    @RequestMapping("/goodsManager/getKillItem")
    public String getKillItem(@RequestBody ItemKillDTO itemKillDTO);


    @RequestMapping("/goodsManager/saveKillItem")
    public String saveKillItem(@RequestBody ItemKillsaveDTO itemKillsaveDTO);


    @RequestMapping("/goodsManager/getForKill")
    public String getForKill();


    @RequestMapping("/goodsManager/kill")
    public String beginKill(@RequestParam("killId") Integer killId,@RequestParam("userId") Integer userId);

    @RequestMapping("/goodsManager/selectKillSuccess")
    public String selectSingleKillSuccess(@RequestParam("code") String code);


}
