package com.zking.killprovider.service.Impl;

import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillsaveDTO;
import com.zking.killprovider.mapper.ItemKillMapper;
import com.zking.killprovider.model.ItemKill;
import com.zking.killprovider.service.IItemKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/19 22:56
 * @Version 1.0
 */
@Service
public class ItemKillServiceImpl implements IItemKillService {

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return itemKillMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insert(ItemKillsaveDTO itemKillsaveDTO) {
        return itemKillMapper.insert(itemKillsaveDTO);
    }

    @Override
    public int insertSelective(ItemKill record) {
        return itemKillMapper.insertSelective(record);
    }

    @Override
    public ItemKill selectByPrimaryKey(Integer id) {
        return itemKillMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemKill record) {
        return itemKillMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ItemKill record) {
        return itemKillMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ItemKillDTO> getAllKill(ItemKillDTO itemKillDTO) {
        return itemKillMapper.getAllKill(itemKillDTO);
    }

    @Override
    public List<ItemKillDTO> getForKill() {
        return itemKillMapper.getForKill();
    }
}
