package javaer.code;

import java.util.ArrayList;
import java.util.List;

/**序列化二叉树
 *序列化&反序列化
 */
public class C37_tree_SerializeAndDeserializeTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    static class Solution{
        public static int index = -1;
        public static void serialize(TreeNode root){
            if(root==null){
                System.out.print("$");
                return;
            }
            System.out.print(root.val);
            serialize(root.left);
            serialize(root.right);
        }
        public static void deserialize(TreeNode root,String str){
            int index;

        }
        static TreeNode deserialize(String str) {
            index++;
            String[] arrStr = str.split("");
            TreeNode treeNode = null;
            if(!arrStr[index].equals("$")){
                treeNode = new TreeNode(Integer.valueOf(arrStr[index]));
                treeNode.left = deserialize(str);
                treeNode.right = deserialize(str);
            }
            return treeNode;
        }



        public static void main(String[] args) {
            /*       1
                   2    3
                 4    5  6
             */
            TreeNode root=new TreeNode(1);
            TreeNode root2=new TreeNode(2);
            TreeNode root3=new TreeNode(3);
            TreeNode root4=new TreeNode(4);
            TreeNode root5=new TreeNode(5);
            TreeNode root6=new TreeNode(6);
            root.left=root2;
            root.right=root3;
            root2.left=root4;
            root3.left=root5;
            root3.right=root6;
            serialize(root);
            //反序列化
            String str="124$$$35$$6$$";
            TreeNode node = deserialize(str);
            List<TreeNode> list = new ArrayList<>();
            C32_tree_PrintTree1 printTree = new C32_tree_PrintTree1();

//            list =
//            list = solution.printFromTopToBottom(node);
            for (TreeNode treeNode:list) {
                System.out.println(treeNode.val);
            }

        }
    }

}
