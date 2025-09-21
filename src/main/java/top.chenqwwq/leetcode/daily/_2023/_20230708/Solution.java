package top.chenqwwq.leetcode.daily._2023._20230708;


/**
 * @author chenqwwq
 * @date 2023/7/8
 **/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        final int n = numbers.length;
        for (int i = 0; i < n; i++) {
            final int idx = get(numbers, i + 1, n - 1, target - numbers[i]);
            if (target == numbers[i] + numbers[idx]) return new int[]{i + 1, idx + 1};
        }
        return new int[]{};
    }

    public int get(int[] nums, int l, int r, int t) {
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] == t) return mid;
            else if (nums[mid] > t) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        new Solution().twoSum(new int[]{-1, -1, 1, 1, 1}, -2);
    }
}