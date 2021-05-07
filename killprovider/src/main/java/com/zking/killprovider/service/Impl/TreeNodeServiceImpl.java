package com.zking.killprovider.service.Impl;

import com.zking.killcommon.dto.TreeNodeDTO;
import com.zking.killprovider.mapper.TreeNodeMapper;
import com.zking.killprovider.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/15 10:54
 * @Version 1.0
 */
@Service
public class TreeNodeServiceImpl implements ITreeNodeService {
    @Autowired
    private TreeNodeMapper treeNodeMapper;


    @Override
    public List<TreeNodeDTO> getParent() {
        return treeNodeMapper.getParent();
    }

    @Override
    public List<TreeNodeDTO> getChidren(TreeNodeDTO treeNodeDTO) {
        return treeNodeMapper.getChidren(treeNodeDTO);
    }
}
