package top.chenqwwq.leetcode.biweek._86._2;

/**
 * @author chenqwwq
 * @date 2022/9/3
 **/
public class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String s1 = Integer.toString(n, i);
            System.out.println(s1);
            int k = s1.length();
            for(int q =0,p = k-1;q < p;q++,p--){
                if(s1.charAt(q) != s1.charAt(p)){
                    return false;
                }
            }
        }
        return true;
    }
}