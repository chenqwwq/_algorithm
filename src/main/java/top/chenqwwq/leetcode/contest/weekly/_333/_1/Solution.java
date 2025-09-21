package top.chenqwwq.leetcode.contest.weekly._333._1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author chenqwwq
 * @date 2023/2/20
 **/
public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        final int n = nums1.length, m = nums2.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                ans.add(new int[]{nums1[i][0], nums2[i][1] + nums1[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                ans.add(nums1[i++]);
            } else {
                ans.add(nums2[j++]);
            }
        }

        while (i < n) {
            ans.add(nums1[i++]);
        }
        while (j < m) {
            ans.add(nums2[j++]);
        }
        final int k = ans.size();
        int[][] ret = new int[k][2];
        for (int q = 0; q < k; q++) {
            ret[q] = ans.get(q);
        }
        return ret;
    }
}