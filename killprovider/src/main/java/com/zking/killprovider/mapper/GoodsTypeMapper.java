package com.zking.killprovider.mapper;

import com.zking.killcommon.dto.GoodsTypeDTO;
import com.zking.killcommon.dto.TreeNodeDTO;
import com.zking.killprovider.model.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    /**
     * 查询所有商品种类
     * @return
     */
    List<GoodsTypeDTO> getGoodsType();

}