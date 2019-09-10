package com.algorithm.leetcode.test.listnode;

import com.algorithm.leetcode.core.method.ListNodeUtil;
import com.algorithm.leetcode.core.model.ListNode;
import com.algorithm.leetcode.test.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: algorithm-and-data-structure
 * 模块名称: com.algorithm.leetcode.test
 * 说明:
 * JDK 版本: JDK1.8
 *
 * @author 作者：chenqiguang
 * 创建日期：2019-09-10
 */
public class ListNodeTest extends BaseUnitTest {
    @Autowired
    private ListNodeUtil listNodeUtil;

    private ListNode generateListNode(int val1,int ... val){
        ListNode l1 = new ListNode(val1);
        ListNode temp = l1;
        for (int i=0;i<val.length;i++){
            if (val[i] < 0){
                continue;
            }
            temp.next = new ListNode(val[i]);
            temp = temp.next;
        }
        return l1;
    }

    @Test
    public void testAddTwoNumbers(){
        ListNode l1 = generateListNode(2,4,3);
        ListNode l2 = generateListNode(5,6,4);

        ListNode listNode = listNodeUtil.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    @Test
    public void testRemoveNthFromEnd(){
        ListNode l1 = generateListNode(1,2,3,4,5);

        ListNode listNode = listNodeUtil.removeNthFromEnd(l1, 5);
        System.out.println(listNode);
    }

    @Test
    public void testMergeTwoLists(){
        ListNode l1 = generateListNode(1,2,4);
        ListNode l2 = generateListNode(1,3,4);

        ListNode listNode = listNodeUtil.mergeTwoLists(new ListNode(1),null);
        ListNode listNode1 = listNodeUtil.mergeTwoLists(null,new ListNode(0));
        ListNode listNode2 = listNodeUtil.mergeTwoLists(l1,l2);
        System.out.println(listNode);
        System.out.println(listNode1);
        System.out.println(listNode2);
    }

    @Test
    public void testMergeKLists(){
        ListNode listNode1 = generateListNode(1, 4, 5);
        ListNode listNode2 = generateListNode(1, 3, 4);
        ListNode listNode3 = generateListNode(2, 6, -1);
        ListNode[] list = new ListNode[]{listNode1,listNode2,listNode3};
        ListNode listNode = listNodeUtil.mergeKLists(list);
        System.out.println(listNode);

    }







}
