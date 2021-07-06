package org.jiang.algorithms.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListIITest {

    int[] vals;
    int left;
    int right;
    ListNode result;
    ReverseLinkedListII rll = new ReverseLinkedListII();

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
    public void reverseBetween() {

        vals = new int[]{1, 2, 3, 4, 5};
        left = 2;
        right = 4;
        ListNode head = createNodeList(vals);
        result = rll.reverseBetween(head, left, right);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

        vals = new int[]{5};
        left = 1;
        right = 1;
        ListNode head1 = createNodeList(vals);
        result = rll.reverseBetween(head1, left, right);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }
}