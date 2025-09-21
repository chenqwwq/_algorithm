package top.chenqwwq.leetcode.archive.$20200418.writte_exam.达西电商;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chen
 * @date 2020/3/24 下午10:02
 */
public class $01 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new $01().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(new $01().merge(new int[][]{{1, 4}, {4, 5}})));

    }

    public int[][] merge(int[][] intervals) {
        // intervals已经完成排序,按照inter[0]排序
        List<int[]> res = new LinkedList<>();
        int[] curr = intervals[0];
        // 一次遍历
        for (int i = 1; i < intervals.length; i++) {
            // 对比中间两个数字,判断是否存在交集
            if (intervals[i][0] > curr[1]) {
                res.add(curr);
                curr = intervals[i];
            } else {
                // 因为已经排序的缘故,curr[0]肯定小于intervals[0]
                // 只需要对右边界取最大值
                curr = new int[]{curr[0], Math.max(intervals[i][1], curr[1])};
            }
        }

        res.add(curr);
        return res.toArray(new int[0][]);
    }
}
