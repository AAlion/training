package javaer.code;

import java.util.*;

/**
 * 一个数据流中的中位数
 *
 * 奇数：取中间
 * 偶数：中间两位的平均值
 *
 * 特性：左边总比右边小
 * ps：左，最大堆，堆顶-最大值，时间复杂度O(1)
 *    右，最小堆，堆顶-最小值，时间复杂度O(1)
 * 步骤：
 * 1.最大堆为空/x<=z堆顶，插入最大堆
 * 2.否则，插入最小堆
 * 3.最大堆.size-最小堆.size=0或1
 * 计算：
 * 1.奇数：最大堆.size>最小堆.size，取最大堆堆顶
 * 2.偶数：最大堆.size=最小堆.size，取2个堆顶/2
 */

public class C41_array_GetMedian {
    public static class Solution {

        //左-最大堆
        private static PriorityQueue<Integer> lHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // o1 - o2 则是小根堆 //PriorityQueue优先队列（也就是堆，默认为小根堆）
            }
        });
        //右-最小堆
        private static PriorityQueue<Integer> rHeap = new PriorityQueue<>();

        //保证lHeap.size() >=rHeap.size();

        public static void Insert(Integer num) {
            //先按大小插入 ，再调整
            if (lHeap.isEmpty() || num < lHeap.peek()) {
                lHeap.offer(num);
            } else {
                rHeap.offer(num);
            }
            //调整
            if (lHeap.size() < rHeap.size()) {
                lHeap.offer(rHeap.peek());
                rHeap.poll();
            } else if (lHeap.size() - rHeap.size() == 2) {
                rHeap.offer(lHeap.peek());
                lHeap.poll();
            }
        }
        public static Double getMedian() {
            if (lHeap.size() > rHeap.size()) {
                return new Double(lHeap.peek());
            } else {
                return new Double(lHeap.peek() + rHeap.peek()) / 2;
            }
        }
        public static void main(String[] args) {
            List<Integer> list =new ArrayList<Integer>(Arrays.asList(8,4,2,6,7,8,1));
            for (Integer num:list) {
                Insert(num);
            }
            System.out.println(new Double(getMedian()));
        }
    }
}
