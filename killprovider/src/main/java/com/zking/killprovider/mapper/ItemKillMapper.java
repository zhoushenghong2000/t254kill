package com.zking.killprovider.mapper;

import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillsaveDTO;
import com.zking.killprovider.model.ItemKill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemKillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemKillsaveDTO itemKillsaveDTO);

    int insertSelective(ItemKill record);

    ItemKill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemKill record);

    int updateByPrimaryKey(ItemKill record);

    /**
     *获取所有秒杀活动记录
     * @param itemKillDTO
     * @return
     */
    List<ItemKillDTO> getAllKill(ItemKillDTO itemKillDTO);

    /**
     * 获取所有秒杀活动（条件判断）
     * @return
     */
    List<ItemKillDTO> getForKill();

    /**
     * 根据秒杀活动的ID判断该商品是否允许秒杀
     * @param killlId
     * @return
     */
    ItemKillDTO selectById(Integer killlId);



}