package top.chenqwwq.leetcode.contest.weekly._356._4;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/7/30
 **/
public class Solution {
    private static final int mod = (int) 1e9 + 7;

    public int countSteppingNumbers(String low, String high) {
        return (calc(high) - calc(low) + mod + (valid(low) ? 1 : 0)) % mod; // +MOD 防止算出负数
    }

    int[][] memo;

    private int calc(String s) {
        final int n = s.length();
        memo = new int[n][10];   // 记忆化处理0～9的数字
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 滴一个数字肯定是受限制的(64,第一个数字最大也只能是6
        // 也肯定不是一个正常的数字
        return handle(s, 0, 0, true, false);
    }

    /**
     * @param s           表示最大的数字
     * @param i           第几位数字
     * @param pre         之前的数字（要根据这个数字判断是否合法
     * @param isLimit     是否被约束（比如123,前面是12的时候第三个数字最多只能是3
     * @param isNum       是否可以跳过当前数字（1 也比 123小
     * @return           合法数字个数
     */
    public int handle(String s, int i, int pre, boolean isLimit, boolean isNum) {
        // 超过长度的时候是数字就可以+1
        if (i >= s.length()) return isNum ? 1 : 0;

        if (!isLimit && isNum && memo[i][pre] != -1) return memo[i][pre];

        int ans = 0;
        // 先忽略当前位数
        if (!isNum) ans = handle(s, i + 1, pre, false, false);

        // 计算上限,比如123 如果前一个是1,那么第二个最高只能是2
        int up = isLimit ? s.charAt(i) - '0' : 9;

        for(int k = isNum ? 0 : 1;k <= up;k++){
            if(!isNum || Math.abs(k-pre) == 1){
                ans = (ans + handle(s,i+1,k,isLimit && k == up,true)) % mod;
            }
            if(!isLimit && isNum) memo[i][pre] = ans;
        }
        return ans;
    }

    private boolean valid(String s) {
        for (int i = 1; i < s.length(); i++)
            if (Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1)) != 1)
                return false;
        return true;
    }
}