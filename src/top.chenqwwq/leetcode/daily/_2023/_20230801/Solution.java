package top.chenqwwq.leetcode.daily._2023._20230801;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author chenqwwq
 * @date 2023/8/1
 **/
public class Solution {
    public int sumOfPower(int[] nums) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(nums);
        long ans = 0, s = 0;
        for (long x : nums) { // x 作为最大值
            ans = (ans + x * x % MOD * (x + s)) % MOD; // 中间模一次防止溢出
            s = (s * 2 + x) % MOD; // 递推计算下一个 s
        }
        return (int) ans;
    }
}