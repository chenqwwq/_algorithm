package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

/**
 * 849. 到最近的人的最大距离
 * <p>
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * <p>
 * 至少有一个空座位，且至少有一人坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 * <p>
 * 1 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 *
 * @author chen
 * @date 2019/12/19 下午10:27
 */
public class $849_MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        System.out.println(new $849_MaximizeDistanceToClosestPerson().new Solution().maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    /**
     * 想麻烦了的方法,单次遍历,累加0
     */
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int size = 0;
            int[] indexes = new int[seats.length];

            // 获取所有1所在的位置
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    indexes[size++] = i;
                }
            }

            int maxLen = Math.max(indexes[0], seats.length - indexes[size - 1]);
            for (int i = 0; i < indexes.length - 1; i++) {
                maxLen = Math.max(indexes[i + 1] - indexes[i] >> 1, maxLen);
            }

            return maxLen - 1;
        }
    }
}
