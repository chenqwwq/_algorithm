package top.chenqwwq.leetcode.contest.biweek._106._1;

/**
 * @author chenqwwq
 * @date 2023/6/10
 **/
public class Solution {
    public boolean isFascinating(int n) {
        if (n > 333) return false;
        int n2 = n * 2, n3 = n * 3;
        int[] hash = new int[10];
        String s = String.valueOf(n) + String.valueOf(n2) + String.valueOf(n3);
        for (char c : s.toCharArray()) {
            hash[c - '0']++;
        }
        if(hash[0] > 0) return false;
        for(int i = 1;i < 10;i++) {
            if(hash[i] != 1) return false;
        }
        return true;
    }
}