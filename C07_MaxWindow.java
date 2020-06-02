package javaer.code;

import java.util.LinkedList;

public class C07_MaxWindow {

    public  static int[] getMaxWindow(int[] arr,int w){

        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //长度为N-w+1 的数组
        int[] res = new int[arr.length - w +1];

        int index = 0;
        for(int i = 0;i<arr.length;i++){
            // 1 双端队列为空，队尾小，推出所有arr[i]
            while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[i]){
                qmax.pollLast();
            }
            //2 添加arr[i]到队尾
            qmax.addLast(i);
            //3 队头过期，推出
            if(qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            if(i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] arr={4,3,5,4,3,3,6,7};
        int[] res = getMaxWindow(arr,3);
        for(int i=0;i<arr.length;i++){
            System.out.println(res[i]);
        }

    }
}
