package javaer.code;

/**
 * 反转链表
 * 定义一个方法（函数），
 * 实现输入一个链表的头结点，然后可以反转这个链表的方向，并输出反转之后的链表的头结点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class C24_list_ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            //p1、p2获取初始值
            ListNode p1 = head;
            ListNode p2 = head.next;
            p1.next = null;
            //遍历链表
            while (p2 != null) {
                ListNode tmp = p2.next; //存储
                p2.next = p1; //断开
                //开始移动
                p1 = p2;  //移动p1
                p2 = tmp; //移动p2
            }
            return p1;
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
            Solution solution = new Solution();
            ListNode res = solution.reverseList(node1);
            System.out.println("res:" + res.val);

    }

    /**
     * 递归
     * https://blog.csdn.net/SoulOH/article/details/81062223
     */
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode subListHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return subListHead;
        }
    }
}
