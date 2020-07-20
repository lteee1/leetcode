package com.lcj.test.other;

import java.util.ArrayDeque;
import java.util.Queue;

public class O24两两交换链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

    public ListNode swapPairs1(ListNode head) {
        Queue<ListNode> queue = new ArrayDeque<>();
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode re = new ListNode(-1);
        head = re;
        while (!queue.isEmpty()) {
            ListNode l1 = queue.poll();
            if (queue.isEmpty()) {
                head.next = l1;
                head=head.next;
                head.next=null;
                return re.next;
            }
            ListNode l2 = queue.poll();
            head.next = l2;
            head = head.next;
            head.next = l1;
            head = head.next;
            head.next=null;
        }
        return re.next;
    }
}
