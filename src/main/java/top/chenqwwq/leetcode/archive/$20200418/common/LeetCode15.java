package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Medium
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author chen
 * @date 19-7-12 上午8:24
 */
public class LeetCode15 {
    // 回溯法全超时
//    /**
//     * backtracking
//     */
//    class Solution {
//
//        private List<List<Integer>> res = new ArrayList<>();
//
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums == null || nums.length < 3) {
//                return res;
//            }
//            // 排序
//            Arrays.sort(nums);
//            backtracking(nums, 0, new ArrayList<>());
//
//            return res;
//        }
//
//        private int getSum(List<Integer> nums){
//            int sum = 0;
//            for (int i : nums){
//                sum += i;
//            }
//            return sum;
//        }
//
//        /**
//         * @param nums  目标值所在数组
//         * @param start 从该位置往后取值
//         * @param list  已经选取的值
//         */
//        public void backtracking(int[] nums, int start, List<Integer> list) {
//            if (list.size() == 3) {
//                if(getSum(list) == 0) {
//                    res.add(new ArrayList<>(list));
//                }
//                return;
//            }
//
//            for (int i = start; i < nums.length; i++) {
//                // ???
//                if (i > start && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                list.add(nums[i]);
//                backtracking(nums, i + 1, list);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        final List<List<Integer>> x = new LeetCode15().new Solution().threeSum(new int[]{0, 0, 0, 0});
        System.out.println(x);
    }

    /**
     * 双指针,
     * 外村循环遍历整个数组,
     * 遍历到i时,从[i+1,len - 1]中使用双指针搜索和nums[i]相加为0的数字
     * 初始双指针定在首位,判断sum大小移动前后指针
     * < 0,则右指针左移使整个和增大
     */
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return res;
            }
            // 排序
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; ) {
                // 如果最小值就大于0可以直接return了
                if (nums[i] > 0) {
                    return res;
                }

                // 提交超时,应该是nums
                // 从statr到end中选取两个组成0
                int start = i + 1;
                int end = nums.length - 1;

                final int num = nums[i];
                while (start < end) {
                    final int num1 = nums[start];
                    final int num2 = nums[end];
                    int sum = num1 + num2 + num;
                    if (sum < 0) {
                        // 右移左边指针
                        while (start < end && nums[start] == nums[++start]) {
                        }
                    } else if (sum > 0) {
                        // 左移右边指针
                        while (start < end && nums[end] == nums[--end]) {
                        }
                    } else {
                        // 添加
                        res.add(new ArrayList<Integer>() {{
                            add(num1);
                            add(num2);
                            add(num);
                        }});
                        // !!! 因为往中间遍历时可能还会有答案,此处不能跳出
                        // 继续往中间遍历
                        // 往右找到第一个和刚才答案中数字不同的数
                        // [0,0,0,0] -> [0,0,0],[0,0,0]
                        while (start < end && nums[start] == nums[++start]) {
                        }
                    }
                }
                // 跳过排序后数组中前后相同的数字
                while (i < nums.length - 2 && nums[i] == nums[++i]) {
                }
            }
            return res;
        }
    }
}
