package top.chenqwwq.leetcode.lcof._2020._65;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * @author chen
 * @date 2020-06-30
 **/
public class Solution {
    public int add(int a, int b) {
        // 位运算实现加法
        while (b != 0) {
            int tempSum = a ^ b;
            int carrySum = (a & b) << 1;
            a = tempSum;
            b = carrySum;
        }

        return a;
    }
}
