package top.chenqwwq.leetcode.weekly._188._2;

/**
 * 5405. 形成两个异或相等数组的三元组数目
 * 给你一个整数数组 arr 。
 * <p>
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <p>
 * a 和 b 定义如下：
 * <p>
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * @author chen
 * @date 2020/5/10 下午2:30
 */
public class Solution {
    public int countTriplets(int[] arr) {
        // a ^ b == 0 --> a == b
        // 所以求a == b只需要求一个异或为0的子串
        // 求所有数目必不可少的需要整体的遍历
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        // 求前缀
        for (int i = 0; i < arr.length - 1; i++) {
            int t = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                t ^= arr[j];
                if (t == 0) {
                    res += (j - i);
                }
            }
        }
        return res;
    }
}