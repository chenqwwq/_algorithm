package top.chenqwwq.leetcode.daily._20220512;

/**
 * @author chenqwwq
 * @date 2022/5/12
 **/
public class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char c = 'a' - 1;
            for (String str : strs) {
                if (c < str.charAt(i)) {
                    ans++;
                    break;
                }
                c = str.charAt(i);
            }
        }
        return ans;
    }
}