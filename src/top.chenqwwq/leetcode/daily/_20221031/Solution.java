package top.chenqwwq.leetcode.daily._20221031;

/**
 * @author chenqwwq
 * @date 2022/10/31
 **/
public class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int num = 1, ans = 1;
        for (int i = 2; sb.length() < n; i++) {
            int cnt = sb.charAt(i) - '0';
            while (cnt-- > 0 && sb.length() < n) {
                sb.append(num);
                ans += (num & 1);
            }
            num ^= 3;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().magicalString(7);
    }
}