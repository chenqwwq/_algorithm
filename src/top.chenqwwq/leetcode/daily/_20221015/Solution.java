package top.chenqwwq.leetcode.daily._20221015;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/10/15
 **/
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        final int m = target.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < m && j < n;j++) {
            if (target[i] == j + 1) {
                ans.add("Push");
                i++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}