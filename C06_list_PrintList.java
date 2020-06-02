package javaer.code;

import java.util.Stack;

/**面试题 6
 * 从尾到头打印链表
 */

public class C06_list_PrintList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        // 先进后出-栈
        public static void PrintList(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            if (head == null) {
                return;
            }
            ListNode node = head;
            while (node != null) {// 入栈
                stack.push(node);
                node = node.next;
            }
            while (!stack.isEmpty()) {// 出栈打印
                node = stack.peek();
                System.out.println(node.val);
                stack.pop();
            }

        }

        //递归的本质是一个栈结构
        public static void PrintList2(ListNode head) {
            if (head != null) {
                if (head.next != null) {
                    PrintList2(head.next);
                }
                System.out.println(head.val);
            }
        }


        public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            node1.next = node2;
            node2.next = node3;

            ListNode head = node1;
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }

            System.out.println("-----------");
            PrintList(node1);
            System.out.println("-----------");
            PrintList2(node1);

        }
    }

}
