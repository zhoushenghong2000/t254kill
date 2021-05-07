package com.zking.killprovider.service.Impl;

import com.zking.killcommon.dto.GoodsTypeDTO;
import com.zking.killprovider.mapper.GoodsMapper;
import com.zking.killprovider.mapper.GoodsTypeMapper;
import com.zking.killprovider.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/15 16:15
 * @Version 1.0
 */
@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Override
    public List<GoodsTypeDTO> getGoodsType() {
        return goodsTypeMapper.getGoodsType();
    }
}
