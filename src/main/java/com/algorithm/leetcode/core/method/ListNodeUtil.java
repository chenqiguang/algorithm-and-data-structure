package com.algorithm.leetcode.core.method;

import com.algorithm.leetcode.core.model.ListNode;
import org.springframework.stereotype.Component;

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



}
