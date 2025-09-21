package top.chenqwwq.leetcode.contest.biweek._87._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/17
 **/
public class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        final int n = players.length,m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        for(int i = 0,j = 0;i < n && j < m;){
            if(trainers[j] >= players[i]){
                i++;j++;ans++;
            }else {
                j++;
            }
        }
        return ans;
    }
}