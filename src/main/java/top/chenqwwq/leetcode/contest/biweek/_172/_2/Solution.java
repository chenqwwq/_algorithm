package top.chenqwwq.leetcode.contest.biweek._172._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/12/20
 **/
public class Solution {
    public int maximumSum(int[] nums) {
        final int n = nums.length;

        List<Integer> n0 = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();

        for (int num : nums) {
            int t = num % 3;        // 取余
            if (t == 0) {
                n0.add(num);
            } else if (t == 1) {
                n1.add(num);
            } else if (t == 2) {
                n2.add(num);
            }
        }


        List<Integer> anss = new ArrayList<>();
        n0.sort(Integer::compare);
        n1.sort(Integer::compare);
        n2.sort(Integer::compare);
        // 三个 1
        if (n1.size() >= 3) {
            anss.add(n1.get(n1.size() - 1) + n1.get(n1.size() - 2) + n1.get(n1.size() - 3));
        }

        // 1 2 0
        if (!n1.isEmpty() && !n2.isEmpty() && !n0.isEmpty()) {
            anss.add(n1.get(n1.size() - 1) + n2.get(n2.size() - 1) + n0.get(n0.size() - 1));
        }

        // 三个 0
        if (n0.size() >= 3) {
            anss.add(n0.get(n0.size() - 1) + n0.get(n0.size() - 2) + n0.get(n0.size() - 3));
        }

        if (n2.size() >= 3) {
            anss.add(n2.get(n2.size() - 1) + n2.get(n2.size() - 2) + n2.get(n2.size() - 3));
        }


        anss.sort(Integer::compareTo);
        return anss.isEmpty() ? 0 : anss.get(anss.size() - 1);


    }
}