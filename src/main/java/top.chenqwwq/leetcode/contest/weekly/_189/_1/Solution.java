package top.chenqwwq.leetcode.contest.weekly._189._1;

/**
 * 5412. 在既定时间做作业的学生人数 显示英文描述
 * <p>
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
 * <p>
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * <p>
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 * <p>
 * 提示：
 * <p>
 * startTime.length == endTime.length
 * 1 <= startTime.length <= 100
 * 1 <= startTime[i] <= endTime[i] <= 1000
 * 1 <= queryTime <= 1000
 *
 * @author chen
 * @date 2020/5/17 上午11:05
 */
public class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null || startTime.length == 0) {
            return 0;
        }
        int i = 0;

        int idx = 0;
        while (idx < startTime.length) {
            if (queryTime >= startTime[idx] && queryTime <= endTime[idx]) {
                i++;
            }
            idx++;
        }
        return i;
    }
}