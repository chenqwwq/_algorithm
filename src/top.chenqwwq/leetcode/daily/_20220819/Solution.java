package top.chenqwwq.leetcode.daily._20220819;

/**
 * @author chenqwwq
 * @date 2022/8/19
 **/
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        final int n = startTime.length;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(startTime[i] <= queryTime && endTime[i] >= queryTime){
                cnt++;
            }
        }
        return cnt;
    }
}