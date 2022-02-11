package top.chenqwwq.leetcode.weekly._236._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/4/11
 **/
public class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int curr = 0;
        while (list.size() != 1) {
            curr = (curr + k - 1) % list.size();
            list.remove(curr);
        }

        return list.get(0);
    }
}
