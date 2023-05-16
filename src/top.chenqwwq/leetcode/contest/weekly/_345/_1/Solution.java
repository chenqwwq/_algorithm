package top.chenqwwq.leetcode.contest.weekly._345._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/5/14
 **/
public class Solution {
    public int[] circularGameLosers(int n, int k) {
        int[] hash = new int[n];
        int cnt = 1, cur = 0;
        hash[0] = 1;
        while (true) {
            cur = (k * cnt + cur) % n;
            System.out.println(cur);
            if (++hash[cur] == 2) break;
            cnt++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hash[i] == 0) ans.add(i+1);
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
}