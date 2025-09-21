package top.chenqwwq.leetcode.contest.weekly._198._1;

/**
 * 5464. 换酒问题 显示英文描述
 * 通过的用户数1961
 * 尝试过的用户数2201
 * 用户总通过次数1965
 * 用户总提交次数2457
 * 题目难度Easy
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * @author chen
 * @date 2020/7/19 上午10:39
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }

        int res = numBottles, k = numBottles;

        while (k >= numExchange) {
            // numBottles的空瓶子能换多少瓶
            numBottles = k / numExchange;
            k = (k % numExchange) + numBottles;
            res += numBottles;
        }

        return res;
    }
}
