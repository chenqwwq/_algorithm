package top.chenqwwq.leetcode.contest.weekly._448._1;

/**
 * @author chenqwwq
 * @date 2025/5/4
 **/
public class Solution {
    public int maxProduct(int n) {
        int a = 0,b = 0;
        while (n != 0){
            int cur = n % 10;
            if(cur > a){
                b = a;
                a = cur;
            }else if(cur > b){
                b = cur;
            }
            n /= 10;
        }
        return a * b;
    }
}