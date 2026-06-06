package top.chenqwwq.leetcode.archive.$20200418.by_topics.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 961. 重复 N 次的元素
 * <p>
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 * @author bingxin.chen
 * @date 2019/12/19 16:17
 */
public class $961_NRepeatedElementInSize2nArray {
    class Solution {
        public int repeatedNTimes(int[] A) {
            // Set遍历add一遍就好
            // easy
            Set<Integer> map = new HashSet<>(8);
            for (int a : A) {
                if (!map.add(a)) {
                    return a;
                }
            }
            return -1;
        }
    }
}
