package javaer.code;

import java.util.Stack;

public class C09_matrix_MaximumSubmatrix {
    public static void main(String[] args) {

    }

    public int maxRecSize(int[][] map){
        if(map==null || map.length==0 || map[0].length==0){
           return 0;
        }
        int maxArea=0;
        int[] height=new int[map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j =0;j<map[0].length;j++){
                height[j]=map[i][j]==0 ? 0 : height[j]+1;
            }
        }
        maxArea = Math.max(maxRecFromBottom(height),maxArea);
        return maxArea;
    }
    //height={3,4,5,4,3,6}
    public int maxRecFromBottom(int[] height){
        if(height==null || height.length==0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1:stack.peek();
                int curArea = (i-k-1)*height[j];
                maxArea=Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
           int j = stack.pop();
           int k = stack.isEmpty() ? -1:stack.peek();
           int curArea =(height.length-k-1)*height[j];
           maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }

}
