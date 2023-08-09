package top.chenqwwq.leetcode.daily._2023._20230807;

/**
 * @author chenqwwq
 * @date 2023/8/7
 **/
public class Solution {
    public void reverseString(char[] s) {
        final int n = s.length;
        int l = 0, r = n - 1;
        while (l < r){
            char c = s[l];
            s[l++]= s[r];
            s[r--] = c;
        }
    }
}