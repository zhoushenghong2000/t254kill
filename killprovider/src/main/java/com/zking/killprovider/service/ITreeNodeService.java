package com.zking.killprovider.service;

import com.zking.killcommon.dto.TreeNodeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 周生洪
 * @Date 2021/4/15 10:53
 * @Version 1.0
 */
@Transactional
public interface ITreeNodeService {
    /**
     * 查询所有父节点
     * @return
     */
    List<TreeNodeDTO> getParent();

    /**
     * 查询所有子节点
     * @param treeNodeDTO
     * @return
     */
    List<TreeNodeDTO> getChidren(TreeNodeDTO treeNodeDTO);
}
