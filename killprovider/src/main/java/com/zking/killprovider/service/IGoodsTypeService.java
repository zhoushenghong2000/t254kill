package com.zking.killprovider.service;

import com.zking.killcommon.dto.GoodsTypeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/15 16:14
 * @Version 1.0
 */
@Transactional
public interface IGoodsTypeService {
    /**
     * 查询所有商品种类
     * @return
     */
    List<GoodsTypeDTO> getGoodsType();
}
