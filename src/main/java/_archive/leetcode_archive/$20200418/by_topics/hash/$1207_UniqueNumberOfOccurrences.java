package top.chenqwwq.leetcode.archive.$20200418.by_topics.hash;

/**
 * 1207. 独一无二的出现次数
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (82)
 * 题解(61)New
 * 提交记录
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author chen
 * @date 2019/10/22 上午8:39
 */
public class $1207_UniqueNumberOfOccurrences {

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {

            // -1000 <= arr[i] <= 1000
            // 第一次遍历映射
            int[] tab = new int[2001];
            int[] frequency = new int[1001];
            for (int i : arr) {
                if (frequency[tab[i + 1000]] > 0) {
                    frequency[tab[i + 1000]]--;
                }
                tab[i + 1000]++;
                frequency[tab[i + 1000]]++;

            }
            // 遍历频率数组
            for (int i : frequency) {
                if (i > 1) {
                    return false;
                }
            }

            return true;
        }
    }
}
