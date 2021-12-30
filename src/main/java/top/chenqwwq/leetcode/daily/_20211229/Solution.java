package top.chenqwwq.leetcode.daily._20211229;

/**
 * @author chenbingxin
 * @date 2021/12/29
 **/
public class Solution {
    public int countQuadruplets(int[] nums) {
        final int n = nums.length;
        if (n < 4) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k+1;l < n;l++) {
                        if(nums[i] + nums[j] + nums[k] == nums[l]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
