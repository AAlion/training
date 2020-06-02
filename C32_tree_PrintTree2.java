package javaer.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PrintTopToBottom
 * 从上到下打印二叉树
 *     1
 *   2   3
 * 4  5
 * 从上到下按层每层打印 第一层1、第二层2,3、第三层4,5
 * ps：一个队列，两个计数器
 */
public class C32_tree_PrintTree2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution{
        public void printFromTopToBottom(TreeNode root){
            Queue<TreeNode> queue= new LinkedList<>();

            if(root==null){
                return;
            }
            queue.offer(root);

            int toPrint=1; //本行 root
            int nextPrint=0; //下一行

            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                System.out.println(node.val);

                if(node.left!=null){
                    queue.offer(node.left);
                    ++nextPrint;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    ++nextPrint;
                }

                toPrint--;
                if(toPrint==0){
                    System.out.println("------"); // 一行
                    toPrint=nextPrint;
                    nextPrint=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<ArrayList<TreeNode>> list =new ArrayList<>();
        Solution solution = new Solution();
        TreeNode root=new TreeNode(1);
        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(3);
        TreeNode root4=new TreeNode(4);
        TreeNode root5=new TreeNode(5);
        root.left=root2;
        root.right=root3;
        root2.left=root4;
        root2.right=root5;
        solution.printFromTopToBottom(root);

    }

}
