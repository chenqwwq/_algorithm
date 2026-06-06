package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;

/**
 * 526. Beautiful Arrangement
 * Medium
 * <p>
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * <p>
 * <p>
 * Now given N, how many beautiful arrangements can you construct?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation:
 * <p>
 * The first beautiful arrangement is [1, 2]:
 * <p>
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * <p>
 * The second beautiful arrangement is [2, 1]:
 * <p>
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * <p>
 * <p>
 * Note:
 * <p>
 * N is a positive integer and will not exceed 15.
 * <p>
 * <p>
 * 回溯+剪枝
 * <p>
 * <p>
 * 第一次提交: 剪枝或者遍历方式错误
 * 第二次提交: 273ms，待优化
 * 第三次提交: 32ms
 *
 * @author bingxin.chen
 * @date 2019/7/11 16:09
 */
public class LeetCode526 {
    public static void main(String[] args) {
        System.out.println(new LeetCode526().new Solution().countArrangement(3));
    }

    class Solution {
        // the result
        int resSum = 0;

        /**
         * 第二次打败了5%的人感觉可以在优化一下,
         * 使用数组交换的思路而非动态数组
         */
        public int countArrangement(int N) {
            // init array
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = i + 1;
            }
            dfs(nums, 0);
            return resSum;
        }

        public void dfs(int[] nums, int currIndex) {
            if (currIndex == nums.length) {
                System.out.println(Arrays.toString(nums));
                resSum++;
                return;
            }

            // 从当前开始向后遍历
            for (int i = currIndex; i < nums.length; i++) {
                swap(nums, currIndex, i);
                if (nums[currIndex] % (currIndex + 1) == 0 || (currIndex + 1) % nums[currIndex] == 0) {
                    dfs(nums, currIndex + 1);
                }
                swap(nums, currIndex, i);
            }

        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//
//        // Initial array
//        LinkedList<Integer> list = new LinkedList<>();
//
//        public int countArrangement(int N) {
//            for (int i = 1; i <= N; i++) {
//                list.add(i);
//            }
//            dfs(new ArrayList<>(),0, N, list);
//            return resSum;
//        }
//
//        public void dfs(List<Integer> list,int currIndex, int N, LinkedList<Integer> remaining) {
//            // dfs + 回溯 + 剪枝
//            if (currIndex == N && remaining.size() == 0) {
//                System.out.println(Arrays.toString(list.toArray()));
//                resSum++;
//                return;
//            }
//            for (int j = 0; j < remaining.size(); j++) {
//                // 取数
//                final Integer integer = remaining.get(j);
//                // 判断
//                if (integer % (currIndex + 1) == 0 || (currIndex + 1) % integer == 0) {
//                    // 先删除
//                    remaining.remove(integer);
//                    dfs(list,currIndex + 1, N, remaining);
//                    // 加回去
//                    remaining.add(j, integer);
//                }
//            }
//        }
//    }
}
