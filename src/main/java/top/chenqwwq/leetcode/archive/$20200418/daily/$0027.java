package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * @author chen
 * @date 2020/3/27 上午8:50
 */
public class $0027 {
    public static void main(String[] args) {
    }

    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int[] counts = new int[10000];
            for (int d : deck) {
                counts[d]++;
            }

            int pre = -1;
            for (int i : counts) {
                if (i == 0) {
                    continue;
                }
                if (pre == -1) {
                    pre = i;
                    continue;
                }

                pre = gcd(pre, i);
                if (pre < 2) {
                    return false;
                }

            }
            return pre >= 2;
        }

        /**
         * 辗转相除法求最大公约数
         */
        public int gcd(int m, int n) {
            return n == 0 ? m : gcd(n, m % n);
        }
    }
}
