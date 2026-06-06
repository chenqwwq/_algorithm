package top.chenqwwq.leetcode.contest.weekly._309._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/4
 **/
public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] hash = new int[26], dis = new int[26];
        Arrays.fill(dis,-1);
        Arrays.fill(hash,-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash[c - 'a'] == -1) {
                hash[c - 'a'] = i;
            } else {
                dis[c - 'a'] = i - hash[c - 'a'] -1;
            }
        }

        for(int i = 0;i < 26;i++){
            if(dis[i] != -1 && dis[i] != distance[i]){
                return false;
            }
        }

        return true;
    }
}