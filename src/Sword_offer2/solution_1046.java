package Sword_offer2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class solution_1046 {

}
class Solution1046 {
    //递归
    public int lastStoneWeight(int[] stones) {
        if (stones.length==1){return stones[0];}
        if (stones.length==2){return Math.abs(stones[1]-stones[0]);}
        Arrays.sort(stones);
        //结束递归条件
        if (stones[stones.length-3]==0){
            return stones[stones.length-1]-stones[stones.length-2];
        }
        stones[stones.length-1] = stones[stones.length-1] - stones[stones.length-2];
        stones[stones.length-2] = 0;
        return lastStoneWeight(stones);
    }
    //大顶堆
    public int lastStoneWeight2(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for (int stone:stones){
            pq.offer(stone);
        }
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if (a>b){
                pq.offer(a-b);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
