package com.algorithm.leetcode.test.listnode;

import com.algorithm.leetcode.core.method.ListNodeUtil;
import com.algorithm.leetcode.core.model.ListNode;
import com.algorithm.leetcode.test.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Test
    public void testAddTwoNumbers(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = listNodeUtil.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }


}
