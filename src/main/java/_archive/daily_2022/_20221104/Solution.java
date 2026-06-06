package top.chenqwwq.leetcode.daily._2022._20221104;

/**
 * @author chenqwwq
 * @date 2022/11/4
 **/
public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int ans = 1, pos = 0;
        while (pos < target) pos += ans++;
        if (pos == target) return ans - 1;
        if ((pos - target & 1) == 0) return ans;
        if (((pos + ans++ - target) & 1) == 0) return ans;
        return ans + 1;
    }

    public static void main(String[] args) {
        new Solution().reachNumber(5);
    }
}