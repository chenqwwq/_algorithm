package top.chenqwwq.leetcode.daily._2022._20221016;

/**
 * @author chenqwwq
 * @date 2022/10/17
 **/
public class Solution {
    public int totalFruit(int[] fruits) {
        final int n = fruits.length;
        int[] cs = new int[100001];
        int type = 0,ans = 0;
        int l = 0, r = 0;
        while (l <= r && r < n) {
            if (++cs[fruits[r]] == 1 && ++type > 2) {
                while (l <= r && --cs[fruits[l++]] != 0) {}
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().totalFruit(new int[]{1,2,3,2,2});
    }
}