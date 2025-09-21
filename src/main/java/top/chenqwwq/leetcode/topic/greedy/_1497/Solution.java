package top.chenqwwq.leetcode.topic.greedy._1497;

/**
 * 1497. 检查数组对是否可以被 k 整除
 * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 * <p>
 * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
 * <p>
 * 如果存在这样的分法，请返回 True ；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * 输出：true
 * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5,6], k = 7
 * 输出：true
 * 解释：划分后的数字对为 (1,6),(2,5) 以及 (3,4) 。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5,6], k = 10
 * 输出：false
 * 解释：无法在将数组中的数字分为三对的同时满足每对数字和能够被 10 整除的条件。
 * 示例 4：
 * <p>
 * 输入：arr = [-10,10], k = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：arr = [-1,1,-2,2,-3,3,-4,4], k = 3
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr.length == n
 * 1 <= n <= 10^5
 * n 为偶数
 * -10^9 <= arr[i] <= 10^9
 * 1 <= k <= 10^5
 *
 * @author chen
 * @date 2020-10-26
 **/
public class Solution {

    public boolean canArrange(int[] arr, int k) {
        // 以为10^5次方很大了，不适合定义数组代替,发现好像还行
        int[] hash = new int[k];
        for (int i : arr) {
            int tmp = i % k;
            int idx = tmp >= 0 ? tmp : tmp + k;
            hash[idx]++;
        }
        for (int i = 1; i < k; i++) {
            if (hash[i] != hash[k - i]) {
                return false;
            }
        }

        return (hash[0] & 1) != 1;
    }

//    public boolean canArrange(int[] arr, int k) {
    // 对整个数组取余数
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] %= k;
//        }
//
//        // hash存放
//        Map<Integer, Integer> hash = new HashMap<>();
//        for (int i : arr) {
//            // k == 5,-1这里需要转化成4
//            final int key = i >= 0 ? i : i + k;
//            hash.put(key, hash.getOrDefault(key, 0) + 1);
//        }
//
//        // 遍历所有key
//        for (int i : hash.keySet()) {
//            if (i != 0) {
//                if (!hash.get(i).equals(hash.get(k - i))) {
//                    return false;
//                }
//            }
//        }
//        return (hash.getOrDefault(0, 0) & 1) == 0;
//    }
}
