package com.quincy.laboratory.exam.jianxinjinke.q001;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode head = buildListNode(new int[] {1,2,3,4,4,4,4,5,6,7,8,8});
        printNodeList(head);

        reverseList(head);
        printNodeList(head);
    }

    private static ListNode buildListNode(int[] nums) {
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return preHead.next;
    }

    private static void printNodeList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1);
        // write code here
        ListNode preHead = new ListNode(-1), cur = head, next = head;
        preHead.next = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (next != null) {
            if (cur == next) {
                next = next.next;
            }
            while (next != null && cur.val != next.val) {
                stack.push(cur);
                next = next.next;
                cur = cur.next;
            }
            while (!stack.isEmpty()) {
                preHead.next = stack.pop();
                preHead = preHead.next;
            }
        }
        return head;
    }


    public static int count(String s) {
        // write code here
        if (!s.contains(" ")) return 0;
        int sum = 0;
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length - 2; i++) {
            if (strings[i].equals(strings[i + 1]) && !strings[i + 1].equals(strings[i + 2])) {
                sum++;
                i++;
            }
        }
        return sum;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

