package top.chenqwwq.leetcode.daily._2025._20251219;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2025/12/20
 **/
public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        final int m = meetings.length;
        final List<Integer> ans = new ArrayList<>();
        ans.add(0);

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));      // 按照会议时间排序
        final Set<Integer> vis = new HashSet<>();
        vis.add(0);
        vis.add(firstPerson);       // time = 0 的时候传播给了第一个人

        int cur = 1;
        for (int[] meeting : meetings) {        // 遍历所有的会议
            

        }

        return ans;
    }
}