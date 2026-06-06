package top.chenqwwq.leetcode.contest.weekly._213._2;

/**
 * @author chen
 * @date 2020/11/1
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countVowelStrings(2);
    }

    public int countVowelStrings(int n) {
        if (n == 1) {
            return 5;
        }
        int[] arr = new int[]{1, 1, 1, 1, 1};
        while (--n > 0) {
            for (int i = 1; i < 5; i++) {
                arr[i] = arr[i] + arr[i - 1];
            }
        }

        return arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
    }
}