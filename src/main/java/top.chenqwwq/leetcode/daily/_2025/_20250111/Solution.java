package top.chenqwwq.leetcode.daily._2025._20250111;

/**
 * @author chenqwwq
 * @date 2025/1/11
 **/
public class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int[] a = toNs(num1), b = toNs(num2), c = toNs(num3);
        int[] ans = new int[4];
        for (int i = 0; i < 4; i++) {
            ans[i] = Math.min(Math.min(a[i], b[i]), c[i]);
        }
        return ans[0] + ans[1] * 10 + ans[2] * 100 + ans[3] * 1000;
    }


    public int[] toNs(int num) {
        int[] ns = new int[4];
        for (int i = 0; i < 4; i++) {
            if (num != 0) {
                ns[i] = num % 10;
                num /= 10;
            } else {
                ns[i] = 0;
            }
        }
        return ns;
    }
}