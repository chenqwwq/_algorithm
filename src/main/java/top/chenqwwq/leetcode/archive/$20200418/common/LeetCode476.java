package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 476. Number Complement 求数字的补码
 * <p>
 * 原码: 第一位表示符号,其余表示值
 * 反码: 整数反码是本身,负数反码符号位不变其余取反
 * 补码: 正数补码就是其本身,负数时反码+1
 *
 * @author chen
 * @date 19-4-27
 */
public class LeetCode476 {
    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(6));
    }

    class Solution {
        public int findComplement(int num) {
            return num ^ ((Integer.highestOneBit(num) << 1) - 1);
        }
    }
}
