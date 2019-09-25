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

    @Test
    public void testSwapPairs(){
        ListNode node  = generateListNode(1,2,3,4);
        ListNode listNode = listNodeUtil.swapPairs(node);
        System.out.println(listNode);
    }

    @Test
    public void testDeleteDuplicates(){
        ListNode node = generateListNode(1,1,2,3,3);
        ListNode node1 = listNodeUtil.deleteDuplicates(node);
        System.out.println(node1);
    }

    @Test
    public void testDeleteDuplicates2(){
        ListNode node = generateListNode(1,1);
        ListNode node1 = listNodeUtil.deleteDuplicates2(node);
        System.out.println(node1);
    }

    @Test
    public void testRotateRight(){
        ListNode node1 = generateListNode(1,2,3,4,5);
//        ListNode node2 = generateListNode(1,2);

        ListNode rotateRight = listNodeUtil.rotateRight(node1, 2);
//        ListNode rotateRight1 = listNodeUtil.rotateRight(node2, 1);
        System.out.println(rotateRight);
//        System.out.println(rotateRight1);

    }

    @Test
    public void testPartition(){
        ListNode node = generateListNode(1,4,3,4,5,2);
        ListNode partition = listNodeUtil.partition(node, 3);
        System.out.println(partition);
    }

    @Test
    public void testReverseBetween(){
        ListNode node = generateListNode(1,2,3,4,5);
        ListNode node1 = listNodeUtil.reverseBetween(node, 2, 4);
        System.out.println(node1);
    }

    @Test
    public void testHasCycle(){
        ListNode node = generateListNode(3,2,0,4);
//        int pos = 1;
//        ListNode cusuor = node;
//        for (int i=0;i<pos;i++){
//            cusuor = cusuor.next;
//        }
//        ListNode cusuor1 = node;
//        for (;cusuor1.next!=null;){
//            cusuor1 = cusuor1.next;
//        }
//
//        cusuor1.next = cusuor;

        boolean hasCycle = listNodeUtil.hasCycle(node);
        System.out.println(hasCycle);
    }


}
