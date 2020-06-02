package javaer.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PrintTopToBottom
 * 从上到下打印二叉树
 *     1
 *   2   3
 * 4  5
 * 从上到下按层顺序打印 12345
 * ps：一个队列
 */
public class C32_tree_PrintTree1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution{
        public ArrayList<TreeNode> printFromTopToBottom(TreeNode root){
            ArrayList<TreeNode> list =new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if(root==null){
                return list;
            }
            list.add(root);
            queue.offer(root);

            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    list.add(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    list.add(node.right);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        ArrayList<TreeNode> list =new ArrayList<>();
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
        list = solution.printFromTopToBottom(root);
        for (TreeNode treeNode:list) {
            System.out.println(treeNode.val);
        }
    }

}
