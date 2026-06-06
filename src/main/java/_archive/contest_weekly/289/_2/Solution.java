package top.chenqwwq.leetcode.contest.weekly._289._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/4/17
 **/
public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            boolean flag = false;
            for (int i = cnt / 3; i >= 0; i--) {
                if ((cnt - i * 3) % 2 == 0) {
                    flag = true;
                    ans += i + ((cnt - i * 3) / 2);
                    break;
                }
            }
            if(!flag){
                return -1;
            }
        }
        return ans;
    }

}