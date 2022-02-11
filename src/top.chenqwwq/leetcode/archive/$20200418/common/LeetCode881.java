package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;

/**
 * 881. 救生艇
 * <p>
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 * <p>
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-20 下午3:48
 */
public class LeetCode881 {
    public static void main(String[] args) {
        System.out.println(new LeetCode881().new Solution().numRescueBoats(new int[]{1, 2}, 3));
    }

    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            // 记录说是贪心算法,感觉上有点出入
            if (people == null || people.length == 0) {
                return 0;
            }

            // 先排序
            Arrays.sort(people);

            // 选定双指针两边的下标
            int start = 0, end = people.length - 1, res = 0;

            while (start <= end) {
                // 现装下最重的,剩下的为temp
                int temp = limit - people[end];

                if (temp >= people[start]) {
                    // 装的下最小的
                    start++;
                }
                end--;
                res++;
            }

            return res;
        }
    }
}
