package top.chenqwwq.leetcode.daily._20201104;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @author chen
 * @date 2020-11-04
 **/
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> preAns = new ArrayList<>();
        boolean in = false;

        for (int[] i : intervals) {
            if (in) {
                preAns.add(i);
                continue;
            }
            if (newInterval[1] < i[0]) {
                // 在左边且无交集
                preAns.add(newInterval);
                preAns.add(i);
                in = true;
            } else if (newInterval[0] > i[1]) {
                // 右边无交集
                preAns.add(i);
            } else {
                // 存在交集
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }

        if (!in) {
            preAns.add(newInterval);
        }

        int[][] ans = new int[preAns.size()][];
        for (int i = 0; i < preAns.size(); i++) {
            ans[i] = preAns.get(i);
        }

        return ans;
    }
}