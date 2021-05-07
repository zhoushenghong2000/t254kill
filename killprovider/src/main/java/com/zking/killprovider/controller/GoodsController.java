package com.zking.killprovider.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.killcommon.dto.GoodsDTO;
import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillsaveDTO;
import com.zking.killcommon.dto.TreeNodeDTO;
import com.zking.killprovider.service.*;
import com.zking.killprovider.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 周生洪
 * @Date 2021/4/14 16:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/goodsManager")
@CrossOrigin
public class GoodsController {

    @Autowired
  private  IGoodsTypeService  goodsTypeService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ITreeNodeService treeNodeService;

    @Autowired
    private IItemKillService itemKillService;

    @Autowired
    private ItemKillSuccessService itemKillSuccessService;




    @PostMapping("/savegoods")
    public Map<String,Object> save(@RequestBody GoodsDTO goodsDTO){
        int n =-1;
        String msg = "新增";
        String mm="成功";
       if(goodsDTO.getGid()!=null){
           n = goodsService.updateByPrimaryKeySelective(goodsDTO);
           msg = "修改";
       }else{
          n = goodsService.insertSelective(goodsDTO);
       }
       if(n<=0){
          mm ="失败";
       }
       Map<String,Object> map = new HashMap<>();
       map.put("code",n);
       map.put("msg",msg+mm);
        return map;
    }

    @PostMapping("/del")
    public Map<String,Object> del(@RequestParam("gid") Integer gid,@RequestParam("gstatus") Integer gstatus){
//        System.out.println("gid = " + gid +"  gstatus= "+gstatus);
        String msg=null;
        int n =-1;
        if(gstatus==1){
            msg="请您先下架商品再进行删除";
        }else if(gstatus==0){
            n = goodsService.deleteByPrimaryKey(gid);
            msg ="删除成功";
            if(n<=0){
                msg ="删除失败";
            }
        }
            Map<String,Object> map = new HashMap<>();
            map.put("code",n);
            map.put("msg",msg);
            return map;
    }


    @RequestMapping("/listgoods")
    public  Map<String,Object> getAllgoods(@RequestBody GoodsDTO goodsDTO){
        //前台rows传过来的是每页显示多少条,page页码默认1页5条
        //设置分页数据
        PageHelper.startPage(goodsDTO.getPage(),goodsDTO.getRows());
        //查询所有商品数据
        List<GoodsDTO> list= goodsService.getAllGoods(goodsDTO);
        //然后就查到的数据给pageinfo进行分页处理
        PageInfo pageInfo=new PageInfo(list);

        Map<String,Object> map = new HashMap<>();
        map.put("pageInfo", pageInfo);
        map.put("result",list);
        return map;
    }



   @RequestMapping("/createMenu")
    public List<TreeNodeDTO> getTreeNode(){
        //先查询所有的父节点
        List<TreeNodeDTO> parents = treeNodeService.getParent();
        //tn所有的父节点
        for (TreeNodeDTO tn : parents) {
            //再查询所有的父节点里面的子节点
            List<TreeNodeDTO> chidren = treeNodeService.getChidren(tn);
            tn.setChildren(chidren);
        }
        return parents;
    }

    @RequestMapping("/goodstype")
    public List getgoodstype(){
        return  goodsTypeService.getGoodsType();
    }



    @RequestMapping("/changeStatus")
    public Map<String,Object> changeStatus(@RequestBody GoodsDTO goodsDTO){
        String msg=null;
        int n =-1;
        if(goodsDTO.getGstatus()==1){
                msg="该商品已上架!";
        }else if(goodsDTO.getGstatus()==0){
              msg="该商品已下架!";
        }
        n = goodsService.changeStatus(goodsDTO);
        if(n<=0){
            msg="操作失败";
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",n);
        map.put("msg",msg);
        return map;
    }


    @RequestMapping("/getKillItem")
    public Map<String,Object>  getKillItem(@RequestBody ItemKillDTO itemKillDTO){
        //前台rows传过来的是每页显示多少条,page页码默认1页5条
        //设置分页数据
        PageHelper.startPage(itemKillDTO.getPage(),itemKillDTO.getRows());

        List<ItemKillDTO> allKill = itemKillService.getAllKill(itemKillDTO);
        //然后就查到的数据给pageinfo进行分页处理
        PageInfo pageInfo=new PageInfo(allKill);

        Map<String,Object> map = new HashMap<>();
        map.put("pageInfo", pageInfo);
        map.put("result",allKill);
        return map;
    }

    @RequestMapping("/saveKillItem")
    public Map<String,Object> saveKillItem(@RequestBody ItemKillsaveDTO itemKillsaveDTO){
        String msg="新增成功";
        int n = itemKillService.insert(itemKillsaveDTO);
        if(n<=0){
            msg="新增失败";
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",n);
        map.put("msg",msg);
        return map;
    }

    @RequestMapping("/getForKill")
    public List<ItemKillDTO> getForKill(){
        return itemKillService.getForKill();
    }


    @RequestMapping("/kill")
    public String beginKill(@RequestParam("killId") Integer killId,@RequestParam("userId") Integer userId){
        return itemKillSuccessService.goKill(killId,userId);
    }



    @RequestMapping("/selectKillSuccess")
    public void selectSingleKillSuccess(String code){
        itemKillSuccessService.selectById(code);
    }



}
