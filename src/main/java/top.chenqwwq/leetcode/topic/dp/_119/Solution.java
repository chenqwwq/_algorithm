package top.chenqwwq.leetcode.topic.dp._119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    public List<Integer> getRow(int n) {
        int[][] nums = new int[2][n + 1];
        nums[0][0] = 1;
        int flag = 0;
        for (int i = 1; i <= n; i++) {
            nums[flag ^ 1][0] = 1;
            for (int j = 1; j <= i; j++) {
                nums[flag ^ 1][j] = nums[flag][j - 1] + nums[flag][j];
            }
            flag ^= 1;
        }

        List<Integer> ans = new ArrayList<>();
        for (int num : nums[flag]){
            ans.add(num);
        }
        return ans;
    }
}