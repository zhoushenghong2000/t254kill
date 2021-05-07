package com.zking.killprovider.mapper;

import com.zking.killcommon.dto.ItemKillSuccessDTO;
import com.zking.killprovider.model.ItemKillSuccess;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemKillSuccessMapper {
    int deleteByPrimaryKey(String code);

    int insert(ItemKillSuccess record);

    int insertSelective(ItemKillSuccessDTO record);

    ItemKillSuccess selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ItemKillSuccess record);

    int updateByPrimaryKey(ItemKillSuccess record);


    /**
     * 根据活动编号&用户编号判断用户是否已经参与过秒杀
     * 返回值1：参与过，不允许秒杀哦
     * 返回值0：允许秒杀
     * @param killId
     * @param userId
     * @return
     */
    int selectCount(Integer killId,Integer userId);


    ItemKillSuccessDTO selectById(String code);


    int updateStatus(String code);

}