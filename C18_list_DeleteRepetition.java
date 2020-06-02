package javaer.code;

/**面试18.2 删除链表中的重复节点##
 *
 */
public class C18_list_DeleteRepetition {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
     //3种方法 https://blog.csdn.net/zjkC050818/article/details/72897164
    static class Solution {
        public static void deleteListNode(ListNode head) { //循环实现
            if (head == null || head.next == null) {
                return;
            }
            ListNode node = head;
            ListNode preNode = null;

            while (node != null) {
                ListNode next = node.next;
                boolean needDel = false;
                if (next != null && next.val == node.val) {  // node -> next
                    needDel = true;
                }
                if (!needDel) {//不重复
                    preNode = node;
                    node = node.next;
                } else {       //重复
                    int val = node.val;
                    ListNode toDel = node;   // node  next
                    while (toDel != null && toDel.val == val) {
                        next = toDel.next;
                        toDel = next;
                    }
                    if (preNode == null) {
                        head = next;
                    } else {
                        preNode.next = next;
                    }
                    node = next;
                }

            }
        }

        public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(3);
            node1.next = node2;
            node2.next = node3;
            node3.next=node4;

            ListNode head = node1;
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }

            System.out.println("-----------");
            Solution solution = new Solution();
            solution.deleteListNode(node1);

            ListNode node=node1;
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
}
