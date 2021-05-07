package com.zking.killprovider.service.Impl;

import com.zking.killcommon.dto.GoodsDTO;
import com.zking.killprovider.annotation.Paging;
import com.zking.killprovider.mapper.GoodsMapper;
import com.zking.killprovider.model.Goods;
import com.zking.killprovider.service.IGoodsService;
import com.zking.killprovider.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/14 16:50
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public int deleteByPrimaryKey(Integer gid) {
        return goodsMapper.deleteByPrimaryKey(gid);
    }

    @Override
    public int insertSelective(GoodsDTO record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer gid) {
        return goodsMapper.selectByPrimaryKey(gid);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsDTO record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Paging
    public List<GoodsDTO> getAllGoods(GoodsDTO goodsDTO) {
        return goodsMapper.getAllGoods(goodsDTO);
    }

    @Override
    public int changeStatus(GoodsDTO goodsDTO) {
        return goodsMapper.changeStatus(goodsDTO);
    }
}
