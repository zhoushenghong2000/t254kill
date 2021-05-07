package com.zking.killprovider.mapper;

import com.zking.killcommon.dto.GoodsDTO;
import com.zking.killprovider.model.Goods;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface GoodsMapper {
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

    int changeStatus(GoodsDTO goodsDTO);

    /**
     * 查询所有商品
     * @param goodsDTO
     * @return
     */
    List<GoodsDTO> getAllGoods(GoodsDTO goodsDTO);
}