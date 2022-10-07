package top.chenqwwq.leetcode.contest.biweek._76._4;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/4/16
 **/
public class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        Map<Integer, int[]> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!graph.containsKey(a)) {
                graph.put(a, new int[]{-1, -1, -1});
            }
            int[] nums = graph.get(a);
            if (nums[0] == -1 || scores[b] > scores[nums[0]]) {
                nums[2] = nums[1];
                nums[1] = nums[0];
                nums[0] = b;
            } else if (nums[1] == -1 || scores[b] > scores[nums[1]]) {
                nums[2] = nums[1];
                nums[1] = b;
            } else if (nums[2] == -1 || scores[b] > scores[nums[2]]) {
                nums[2] = b;
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new int[]{-1, -1, -1});
            }
            nums = graph.get(b);
            if (nums[0] == -1 || scores[a] > scores[nums[0]]) {
                nums[2] = nums[1];
                nums[1] = nums[0];
                nums[0] = a;
            } else if (nums[1] == -1 || scores[a] > scores[nums[1]]) {
                nums[2] = nums[1];
                nums[1] = a;
            } else if (nums[2] == -1 ||  scores[a] > scores[nums[2]]) {
                nums[2] = a;
            }

        }

        int ans = -1;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            int tmp = scores[a] + scores[b];
            int fin = -1;
            int[] sa = graph.get(a), sb = graph.get(b);
            for (int i = 0; i < 3; i++) {
                if (sa[i] != -1 && sa[i] != b) {
                    for (int j = 0; j < 3; j++) {
                        if (sb[j] != -1 && sb[j] != a && sb[j] != sa[i]) {
                            fin = Math.max(fin, tmp + scores[sa[i]] + scores[sb[j]]);
                        }
                    }
                }
            }
            ans = Math.max(ans, fin);
        }
        return ans;
    }
}