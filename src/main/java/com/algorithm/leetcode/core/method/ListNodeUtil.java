package com.algorithm.leetcode.core.method;

import com.algorithm.leetcode.core.model.ListNode;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 项目名称: algorithm-and-data-structure
 * 模块名称: com.algorithm.leetcode.core.method
 * 说明:
 * JDK 版本: JDK1.8
 *
 * @author 作者：chenqiguang
 * 创建日期：2019-09-10
 */
@Component
public class ListNodeUtil {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 考察核心是大数相加，不能先加起来，因为可能回溢出
     *
     * 难度级别：中等
     * 链表两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode index = root;
        int add = 0;
        while(l1 != null || l2 != null || add != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + add;
            add = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            index.next = sumNode;
            index = sumNode;

            if(l1 != null) {l1 = l1.next;}
            if(l2 != null) {l2 = l2.next;}
        }

        return root.next;
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n<=0){
            return head;
        }
        int size = 0;
        ListNode tailNode = head;
        for (;;){
            size++;
            if (tailNode.next==null){
                break;
            }
            tailNode = tailNode.next;

        }
        int removeIndex = size - n;
        if (removeIndex==0){
            return head.next;
        }
        ListNode cusuor = head;
        for (int i=0;i<size;i++){
            if (i == removeIndex -1){
                cusuor.next = cusuor.next.next;
                return head;
            }
            cusuor = cusuor.next;
        }
        return head;
    }

    /**
     *
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的.
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cusuor = head;
        while (l1!=null && l2!=null){

            if (l1.val < l2.val){
                cusuor.next = new ListNode(l1.val);
                if (l1!=null){l1 = l1.next;}
                cusuor = cusuor.next;
                continue;
            }else {
                cusuor.next = new ListNode(l2.val);
                if (l2!=null){l2 = l2.next;}
                cusuor = cusuor.next;
                continue;
            }
        }

        if (l2==null){
            cusuor.next = l1;
        }else {
            cusuor.next = l2;
        }

        return head.next;
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        ListNode root = new ListNode(0);
        ListNode curr = root;

        PriorityQueue<ListNode> nodeQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode: lists){
            if (listNode==null){
                continue;
            }
            nodeQueue.add(listNode);
        }

        while (!nodeQueue.isEmpty()){
            ListNode node = nodeQueue.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null){
                nodeQueue.add(node.next);
            }
        }

        return root.next;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     *  两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;

        while (head!=null && head.next!=null){
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;

            pre.next = temp;
            pre = head;
            head = head.next;
        }

        return root.next;
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     * 删除重复的节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode cusuor = head;
        while (cusuor.next!=null){
            if (cusuor.val == cusuor.next.val){
                cusuor.next = cusuor.next.next;
                continue;
            }
            cusuor = cusuor.next;
        }

        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * 删除排序链表中的重复元素 II
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode cusuor = head;
        ListNode pre = new ListNode(0);
        pre.next = cusuor;
        while (cusuor!=null && cusuor.next!=null){
            if (cusuor.val == cusuor.next.val){
                pre.next = cusuor.next.next;
                cusuor = cusuor.next.next;
                continue;
            }
            pre = cusuor;
            cusuor = cusuor.next;
        }

        return head;
    }

    /**
     * 旋转链表
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     *
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     *
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {return null;}
        if (head.next == null) {return head;}

        ListNode old_tail = head;
        int size;
        for(size = 1; old_tail.next != null; size++){
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        ListNode new_tail = head;
        for (int i = 0; i < size - k % size - 1; i++){
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        new_tail.next = null;

        return new_head;
    }

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * 示例:
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     *
     * 分隔链表
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode cusuor = head;

        ListNode suffix = new ListNode(0);
        ListNode tempSuffix = suffix;

        ListNode root = new ListNode(0);
        ListNode tempPre = root;

        while (cusuor!=null){
            if (cusuor.val < x){
                tempPre.next = cusuor;
                tempPre = tempPre.next;
            }else {
                tempSuffix.next = cusuor;
                tempSuffix = tempSuffix.next;
            }
            cusuor = cusuor.next;
        }
        root.next = suffix.next;
        return root.next;
    }















}
