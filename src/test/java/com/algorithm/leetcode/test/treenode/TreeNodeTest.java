package com.algorithm.leetcode.test.treenode;

import com.algorithm.leetcode.core.method.TreeNodeUtil;
import com.algorithm.leetcode.core.model.TreeNode;
import com.algorithm.leetcode.test.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 项目名称: algorithm-and-data-structure
 * 模块名称: com.algorithm.leetcode.test.treenode
 * 说明:
 * JDK 版本: JDK1.8
 *
 * @author 作者：chenqiguang
 * 创建日期：2019-10-08
 */
public class TreeNodeTest extends BaseUnitTest {
    @Autowired
    private TreeNodeUtil treeNodeUtil;
    @Test
    public void testInorderTraversal(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = treeNodeUtil.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void testNumTrees(){
        int i = treeNodeUtil.numTrees(5);

        System.out.println(i);
    }


}
