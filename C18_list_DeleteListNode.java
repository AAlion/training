package javaer.code;

/**面试18.1 删除链表节点
 * 在O（1）时间内删除链表节点
 */
public class C18_list_DeleteListNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    static class Solution{
        public static void deleteListNode(ListNode head,ListNode toDelete){
            if(head==null||toDelete==null){
                return;
            }
            if(head==toDelete){            //1.只有一个节点
                head =null;
            } else if(toDelete.next!=null){//2.要删除的节点不是尾节点
                ListNode tmp =toDelete.next;     //toDelete1 -> tmp -> tmp.next
                toDelete.val=tmp.val;            //toDelete1 = tmp
                toDelete.next=tmp.next;          //删除tmp
                tmp=null;                        //  null  toDetete2(tmp)->toDetete2.next
            }else {                        //3.链表中多个节点，删掉尾节点
                ListNode node =head;
                while (node.next!=toDelete){
                    node=node.next;
                }
                node.next=null;
                toDelete=null;
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
                System.out.print(head.val);
                head = head.next;
            }

            System.out.println();
            System.out.println("-----------");
            Solution solution = new Solution();
            solution.deleteListNode(node1, node2);

            ListNode node=node1;
            while (node != null) {
                System.out.print(node.val);
                node = node.next;
            }
        }
    }
}
