package top.chenqwwq.leetcode.contest.weekly._346._1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenqwwq
 * @date 2023/5/22
 **/
public class Solution {
    int MAXN = 101;

    public int minLength(String s) {
        char[] left = new char[MAXN];
        int l = 0;
        for (char c : s.toCharArray()) {
            left[l++] = c;
            while (l >= 2 && ((left[l - 2] == 'A' && left[l - 1] == 'B') || (left[l - 2] == 'C' && left[l - 1] == 'D'))) {
                l -= 2;
            }
        }
        return l;
    }
}