package com.quincy.laboratory.exam.xiaomi.q001;

import java.util.*;

class ListNode<T> {
    public T data;
    public ListNode next;
}

class Solution {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {

        ListNode<Integer> dummyNode = new ListNode<>();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) pre = pre.next;
        ListNode cur = pre.next;
        for (int i =0;i< right-left;i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyNode.next;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for (int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new Solution().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}



