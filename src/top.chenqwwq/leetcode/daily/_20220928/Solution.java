package top.chenqwwq.leetcode.daily._20220928;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/9/28
 **/
public class Solution {
    int[] nums = new int[]{3, 5, 7};

    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> vis = new HashSet<>();
        pq.add(1L);vis.add(1L);
        int cnt = 0;
        while (!pq.isEmpty()){
            Long num = pq.poll();
            if(++cnt == k) return num.intValue();
            for(int n : nums){
                if(vis.contains(n * num)) continue;
                pq.add(n * num);vis.add(n * num);
            }
        }
        return -1;
    }
}