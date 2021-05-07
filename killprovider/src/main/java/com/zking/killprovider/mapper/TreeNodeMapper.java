package com.zking.killprovider.mapper;

import com.zking.killcommon.dto.TreeNodeDTO;
import com.zking.killprovider.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

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