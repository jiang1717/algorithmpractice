package org.jiang.algorithms.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    int[] vals;
    ListNode result;
    ReverseLinkedList rll = new ReverseLinkedList();

    public ListNode createNodeList(int[] vals) {
        if(vals == null || vals.length < 1){
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        head.next = null;
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode l = new ListNode(vals[i]);
            l.next = null;
            cur.next = l;
            cur = l;
        }
        return head;
    }


    @Test
    public void reverseList() {
        vals = new int[]{1, 2, 3, 4, 5};
        ListNode head = createNodeList(vals);
        result = rll.reverseList(head);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

        vals = new int[]{1,2};
        ListNode head2 = createNodeList(vals);
        result = rll.reverseList(head2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

    }
}