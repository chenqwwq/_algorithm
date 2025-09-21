package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author chen
 * @description `DP`,
 * @email ai654778@vip.qq.com
 * @date 19-1-26
 */
@Slf4j
public class LeetCode673 {
    public static void main(String[] args) {
        log.info(new Solution().findNumberOfLIS(new int[]{1, 2}) + "");
    }

    static class Solution {
        public int findNumberOfLIS(int[] nums) {
            final int length = nums.length;

            // 分别存储最长计数和最长长度
            int[] cnt = new int[length], longest = new int[length];
            // 填充1
            Arrays.fill(cnt, 1);

            int maxLen = 0, res = 0;
            for (int i = 0; i < length; i++) {
                // 内层遍历确定每个元素的最长递增子串长度及个数
                // 动态规划的主要内容:1.大问题如何拆分成小问题 2. 如何保存小问题结果
                // ass_1: 每个元素的最长子串长度等于从前遍历以前结果的处理集合
                // 从i开始往前遍历,遇到每一个比他小的数判断值
                // ans_2: cnt数组存到每个元素为止最长子串的个数,longest存长度
                for (int j = i; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        if (longest[i] == longest[j] + 1) {
                            cnt[i] += cnt[j];
                        }
                        if (longest[i] < longest[j] + 1) {
                            longest[i] = longest[j] + 1;
                            cnt[i] = cnt[j];
                        }
                    }
                }

                if (longest[i] == maxLen) {
                    res += cnt[i];
                }
                if (longest[i] > maxLen) {
                    maxLen = longest[i];
                    res = cnt[i];
                }
            }
            return res;
        }
    }
}
