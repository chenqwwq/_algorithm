package top.chenqwwq.leetcode.daily._20221019;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenqwwq
 * @date 2022/10/19
 **/
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> q = new LinkedList<>();
        for (int num : students) q.addLast(num);
        outer:
        for (int sandwich : sandwiches) {
            int cnt = q.size();
            while (cnt-- > 0) {
                Integer poll = q.pollFirst();
                if (sandwich != poll) q.addLast(poll);
                else continue outer;
            }
            break;
        }
        return q.size();
    }
}