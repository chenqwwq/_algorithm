package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 1052. 爱生气的书店老板
 * <p>
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 *
 * @author chen
 * @date 19-7-14 下午4:00
 */
public class LeetCode1052 {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            // 求和
            int sum = 0;

            // win表示窗口中生气受到影响客户的数目
            int win = 0;
            // max表示窗口内数目的最大值
            int max = 0;
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i] == 0) {
                    sum += customers[i];
                } else {
                    win += customers[i];
                }
                // max中保存的就是X窗口的数目
                // 窗口往前移动的时候,如果出窗的为1,
                // 则减去窗口内的数目
                if (i >= X && grumpy[i - X] == 1) {
                    win -= customers[i - X];
                }
                max = Math.max(win, max);


                // 如果此分钟老板在生气
                // 统计以此刻为启动时间往后X分钟内受影响的客户人数
                // for循环里面在套了一层for 所以效率非常低
//                int total = customers[i];
//                for (int j = i + 1;j < customers.length && j < i + X;j++){
//                    if(grumpy[j] == 1){
//                        total += customers[j];
//                    }
//                }
//                max = Math.max(max,total);

            }
            return sum + max;
        }
    }
}
