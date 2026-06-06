package top.chenqwwq.leetcode.archive.$20200418.writte_exam.达西电商;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chen
 * @date 2019/11/25 下午8:31
 */
public class MergeTime {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
//        if(intervals.length == 1){
//            return intervals;
//        }

        // 结果集
        List<int[]> res = new ArrayList<>();

        // 按照第一个元素拍自然序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        int[] curr = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (curr == null) {
                curr = intervals[i];
                continue;
            }

            int[] arr = intervals[i];
            // 两个范围存在交集进入判断
            if (arr[0] <= curr[1]) {
                if (arr[1] > curr[1]) {
                    curr[1] = arr[1];
                }

                if (arr[0] < curr[0]) {
                    curr[0] = arr[0];
                }
            } else {
                // 没有交集就入结果集
                res.add(curr);
                curr = arr;
            }
        }

        if (curr != null) {
            res.add(curr);
        }

        return tranTo2DArr(res);
    }

    /**
     * 转化结果集
     */
    private int[][] tranTo2DArr(List<int[]> result) {
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }


}
