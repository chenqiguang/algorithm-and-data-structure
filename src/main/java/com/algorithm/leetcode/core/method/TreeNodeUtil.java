package com.algorithm.leetcode.core.method;

import com.algorithm.leetcode.core.model.TreeNode;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: algorithm-and-data-structure
 * 模块名称: com.algorithm.leetcode.core.method
 * 说明:
 * JDK 版本: JDK1.8
 *
 * @author 作者：chenqiguang
 * 创建日期：2019-10-08
 */
@Component
public class TreeNodeUtil {


    /**
     * 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    private void inorder(TreeNode root ,List<Integer> list){
        if(root.left!=null){
            inorder(root.left,list);
        }

        list.add(root.val);

        if (root.right!=null){
            inorder(root.right,list);
        }
    }

}
