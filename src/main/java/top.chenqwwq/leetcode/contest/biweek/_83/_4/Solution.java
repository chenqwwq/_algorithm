package top.chenqwwq.leetcode.contest.biweek._83._4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/7/23
 **/
public class Solution {
    public int shortestSequence(int[] rolls, int k) {
        final int n = rolls.length;
        Set<Integer> s = new HashSet<>();
        int ans = 1;
        for(int roll : rolls){
            s.add(roll);
            if(s.size() == k){
                ans++;
                s.clear();
            }
        }
        return ans;
    }
}