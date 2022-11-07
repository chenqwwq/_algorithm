package top.chenqwwq.leetcode.daily._20221027;

/**
 * @author chenqwwq
 * @date 2022/10/27
 **/
public class Solution {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for(int num : nums){
            if(num == 0) return 0;
            if(num < 0) cnt++;
        }
        return (cnt & 1) == 0 ? 1 : -1;
    }
}