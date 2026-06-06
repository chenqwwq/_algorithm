package top.chenqwwq.leetcode.daily._2025._20251113;

/**
 * @author chenqwwq
 * @date 2025/11/13
 **/
public class Solution {
    public int maxOperations(String s) {
        final int n = s.length();
        int cur = 0, ans = 0;
        boolean needAdd = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') needAdd = true;
            else {
                if (needAdd) {
                    ans += cur;
                }
                cur++;
                needAdd = false;
            }
        }

        return ans + (needAdd ? cur : 0);
    }
}