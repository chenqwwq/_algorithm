package top.chenqwwq.leetcode.lcof2._17;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenbingxin
 * @date 2021/12/29
 **/
public class Solution {
    public String minWindow(String s, String t) {
        final int n = s.length(), m = t.length();
        if (n < m) {
            return "";
        }
        final int[] th = new int[58];
        for (int i = 0; i < m; i++) {
            ++th[t.charAt(i) - 'A'];
        }

        int ans = Integer.MAX_VALUE;
        int start = 0;
        final int[] sh = new int[58];
        final LinkedList<Integer> queue = new LinkedList<>();
        // 当前不匹配的
        for (int i = 0, j = 0; i < n; i++) {
            final int pos = s.charAt(i) - 'A';
            if (th[pos] == 0) {
                continue;
            }
            queue.addLast(i);
            sh[pos]++;
            while (check(sh, th)) {
                final int len = queue.getLast() - queue.getFirst() + 1;
                if (len < ans) {
                    ans = len;
                    start = queue.getFirst();
                }
                sh[s.charAt(queue.removeFirst()) - 'A']--;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }

    private boolean check(int[] h1, int[] h2) {
        for (int i = 0; i < 58; i++) {
            if (h1[i] < h2[i]) {
                return false;
            }
        }
        return true;
    }
}