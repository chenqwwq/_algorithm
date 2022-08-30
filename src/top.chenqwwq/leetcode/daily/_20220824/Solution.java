package top.chenqwwq.leetcode.daily._20220824;

import java.util.Stack;

/**
 * @author chenqwwq
 * @date 2022/8/24
 **/
public class Solution {
    int N = 1001;
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = arr.length, tot = 0;
        int[] hash = new int[N];
        for (int i = 0; i < n; i++) {
            if (++hash[target[i]] == 1) tot++;
            if (--hash[arr[i]] == 0) tot--;
        }
        return tot == 0;
    }
}