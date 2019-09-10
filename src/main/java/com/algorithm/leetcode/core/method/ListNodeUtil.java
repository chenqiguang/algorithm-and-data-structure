package com.algorithm.leetcode.core.method;

import com.algorithm.leetcode.core.model.ListNode;
import org.springframework.stereotype.Component;

import java.util.List;

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
            int val1 = l1!=null ? l1.val : 0;
            int val2 = l2!=null ? l2.val : 0;

            if (val1 < val2){
                cusuor.next = new ListNode(val1);
                if (l1!=null){l1 = l1.next;}
                cusuor = cusuor.next;
                continue;
            }else {
                cusuor.next = new ListNode(val2);
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

}
