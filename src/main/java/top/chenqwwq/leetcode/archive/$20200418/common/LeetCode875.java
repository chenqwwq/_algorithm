package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;

/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-14 下午3:31
 */
public class LeetCode875 {

    public static void main(String[] args) {
        System.out.println(new LeetCode875().new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            // 看到提示说使用二分查找,刚开始真的一点思路都没
            // 还是瞄了眼答案

            // 排序
            Arrays.sort(piles);

            int lo = 1;
            int hi = piles[piles.length - 1];

            // 提示中说 piles.length <= H
            // 所以hi的速度绝对可以吃完所有香蕉
            // 以lo和hi为两端 进行二分查找

            while (lo < hi) {
                int time = 0;
                int mid = lo + (hi - lo) / 2;
                // 评估消耗时间
                for (int i : piles) {
                    // 计算问题
                    // i / min至少为1
                    time += i < mid ? 1 : (i / mid + (i % mid == 0 ? 0 : 1));
                }

                if (time > H) {
                    lo = mid + 1;
                    // mid的时间内可以吃完,减少上限 降低速度
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
