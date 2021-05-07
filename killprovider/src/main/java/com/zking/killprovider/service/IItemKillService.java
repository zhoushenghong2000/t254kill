package com.zking.killprovider.service;

import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillsaveDTO;
import com.zking.killprovider.model.ItemKill;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/19 22:55
 * @Version 1.0
 */
@Transactional
public interface IItemKillService {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemKillsaveDTO ItemKillsaveDTO);

    int insertSelective(ItemKill ItemKillsaveDTO);

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

   
}
