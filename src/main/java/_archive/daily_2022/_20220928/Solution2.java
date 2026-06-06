package top.chenqwwq.leetcode.daily._2022._20220928;

/**
 * @author chenqwwq
 * @date 2022/9/28
 **/
public class Solution2 {

    public int getKthMagicNumber(int k) {
        int[] nums = new int[k];
        nums[0] = 1;
        int c3 = 0, c5 = 0, c7 = 0;
        for (int i = 1; i < k; i++) {
            int n3 = 3 * nums[c3], n5 = 5 * nums[c5], n7 = 7 * nums[c7];
            int min = Math.min(n3, Math.min(n5, n7));
            if (min == n3) c3++;
            if (min == n5) c5++;
            if (min == n7) c7++;
            nums[i] = min;
        }
        return nums[k - 1];
    }
}
