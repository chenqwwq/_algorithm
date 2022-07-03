package top.chenqwwq.leetcode.biweek._81._3;

/**
 * @author chenqwwq
 * @date 2022/6/26
 **/
public class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    cnt++;
                }
            }
            if(cnt > 0){
                ans |= (1 << i);
            }
        }
        return ans;
    }
}