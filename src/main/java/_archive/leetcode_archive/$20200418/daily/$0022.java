package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.Map;
import java.util.TreeMap;

/**
 * 945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 * <p>
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 * <p>
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * @author chen
 * @date 2020/3/22 下午11:27
 */
public class $0022 {
    class Solution {
        public int minIncrementForUnique(int[] A) {
            Map<Integer, Integer> hash = new TreeMap<>();
            for (int i : A) {
                hash.put(i, hash.getOrDefault(i, 0) + 1);
            }

            int res = 0;
            // 因为最大是40000，如果全是是40000的话就会被推到80000
            for (int i = 0; i < 80000; i++) {
                if (!hash.containsKey(i)) {
                    continue;
                }
                final Integer integer = hash.get(i);
                if (integer > 1) {
                    final int i1 = integer - 1;
                    res += i1;
                    hash.put(i + 1, hash.getOrDefault(i + 1, 0) + i1);
                }
            }

            return res;
        }
    }
}
