package top.chenqwwq.leetcode.biweek._39._2;

/**
 * @author chen
 * @date 2020/11/14
 **/
public class Solution {
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        // a的个数
        int[] a = new int[s.length()];
        a[chars.length - 1] = chars[chars.length - 1] == 'a' ? 1 : 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            a[i] = a[i + 1] + (chars[i] == 'a' ? 1 : 0);
        }

        int[] b = new int[s.length()];
        b[0] = chars[0] == 'b' ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            b[i] = b[i - 1] + (chars[i] == 'b' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            ans = Math.min(ans, (i > 0 ? b[i - 1] : 0) + ( i == s.length()-1 ? 0 : a[i]));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions("a"));
    }
}