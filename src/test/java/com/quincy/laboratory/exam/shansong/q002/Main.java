package com.quincy.laboratory.exam.shansong.q002;

import java.util.Scanner;

public class Main {

    static class Node {
        Node next;
        String val;

        Node() {
            this.next = null;
        }

        Node(String val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        String[] nums = in.substring(1, in.length() - 1).split(",");
        Node head = buildList(nums);
        Node rear = reverseList(head);
        printList(rear);
    }

    private static Node reverseList(Node head) {
        Node rear = null;
        while (head != null) {
            Node tmp = head.next;
            head.next = rear;
            rear = head;
            head = tmp;
        }
        return rear;
    }

    private static Node buildList(String[] nums) {
        Node head = new Node();
        if (nums.length == 0) return head;
        head.val = nums[0];
        Node cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    private static void printList(Node head) {
        System.out.print("{");
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        while (head != null) {
            System.out.print("," + head.val);
            head = head.next;
        }
        System.out.print("}");
    }
}
