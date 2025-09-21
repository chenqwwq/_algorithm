package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

/**
 * 561. Array Partition I
 * Easy
 * <p>
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 *
 * @author bingxin.chen
 * @date 2019/10/15 12:17
 */
public class $561_ArrayPartitionI {

    static class Solution {

        private static final Integer SIZE = 20001;

        public int arrayPairSum(int[] nums) {
            // 初始化桶
            int[] bucket = new int[20001];

            // 遍历入桶
            for (int i : nums) {
                bucket[i + 10000]++;
            }

            // 当前计数
            // 仅在计数为奇数的时候附加值
            int count = 0, res = 0, currIndex = 0;

            // 二次遍历,遍历桶
            while (currIndex < SIZE) {
                if (bucket[currIndex] == 0) {
                    currIndex++;
                    continue;
                }
                // 判断奇数
                if ((++count & 1) == 1) {
                    res += currIndex - 10000;
                }
                bucket[currIndex]--;
            }
            return res;
        }

//        public int arrayPairSum(int[] nums) {
//            // java自带的排序Api
//            Arrays.sort(nums);
//
//            int res = 0;
//            for (int i = 0; i < nums.length; i += 2) {
//                res += nums[i];
//            }
//
//            return res;
//        }
    }
}
