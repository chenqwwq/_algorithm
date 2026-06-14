package top.chenqwwq.leetcode.contest.weekly._506._1;

public class Solution {
    public boolean checkGoodInteger(int n) {
        long q = 0,p = 0;
        while (n != 0){
            int t = n % 10;
            q += t;
            p += 1l * t * t;
            n /= 10;
        }       
        return p - q >= 50;
    }
}