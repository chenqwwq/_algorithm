package top.chenqwwq.leetcode.contest.weekly._506._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int getLength(int[] nums) {
        final int n = nums.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> num2Cnt = new HashMap<>(),
                    freq2Num = new HashMap<>();
            for (int j = i; j < n; j++) {
                int cnt = num2Cnt.getOrDefault(nums[j], 0);
                num2Cnt.put(nums[j], cnt + 1);
                freq2Num.merge(cnt + 1, 1, Integer::sum); // 对应出现频率的数量+1
                int oldCnt = freq2Num.getOrDefault(cnt, 0);
                if (oldCnt <= 1)
                    freq2Num.remove(cnt);
                else
                    freq2Num.merge(cnt, -1, Integer::sum);

                if (freq2Num.size() > 2)
                    continue;
                if (freq2Num.size() == 1) {
                    if (num2Cnt.size() == 1) {
                        ans = Math.max(ans, j - i + 1);
                    }
                    continue;
                }
                List<Integer> list = new ArrayList<>(freq2Num.keySet());
                int n1 = list.get(0), n2 = list.get(1);
                if (n1 * 2 == n2 || n2 * 2 == n1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}