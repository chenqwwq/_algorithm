package top.chenqwwq.leetcode.daily._20221004;

import java.util.Stack;

/**
 * @author chenqwwq
 * @date 2022/10/4
 **/
public class Solution {
    public int minAddToMakeValid(String s) {
        final int n = s.length();
        char[] stack = new char[n];
        int idx = 0,ans = 0;
        for(char c : s.toCharArray()){
            if(c == '(') stack[idx++] = c;
            else {
                if(idx > 0) idx--;
                else ans++;
            }
        }
        return ans+idx;
    }
}