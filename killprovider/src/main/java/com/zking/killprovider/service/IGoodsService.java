package com.zking.killprovider.service;

import com.zking.killcommon.dto.GoodsDTO;
import com.zking.killprovider.model.Goods;
import com.zking.killprovider.utils.PageBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IGoodsService {
    /**
     * 删除商品
     * @param gid
     * @return
     */
    int deleteByPrimaryKey(Integer gid);
    /**
     * 新增商品
     * @param record
     * @return
     */
    int insertSelective(GoodsDTO record);

    Goods selectByPrimaryKey(Integer gid);

    /**
     * 修改商品
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GoodsDTO record);

    /**
     * 查询所有商品
     * @param goodsDTO
     * @return
     */
    List<GoodsDTO> getAllGoods(GoodsDTO goodsDTO);


    int changeStatus(GoodsDTO goodsDTO);
}