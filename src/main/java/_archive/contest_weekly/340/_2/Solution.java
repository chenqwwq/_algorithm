package top.chenqwwq.leetcode.contest.weekly._340._2;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author chenqwwq
 * @date 2023/4/9
 **/
public class Solution {
    public long[] distance(int[] nums) {
        final int n = nums.length;
        Map<Integer, Long> sum = new HashMap<>(),
                cnt = new HashMap<>(),
                preCnt = new HashMap<>(),
                preSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum.put(nums[i], sum.getOrDefault(nums[i], 0L) + i);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0L) + 1);
        }

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            long total = cnt.get(num);
            if (total == 1) {
                arr[i] = 0;
                continue;
            }
            long ts = sum.get(num), ps = preSum.getOrDefault(num,0L), pc = preCnt.getOrDefault(num,0L);
            arr[i] =  pc * i - ps + ts - ps - (total - pc) * i;
            preCnt.put(num, preCnt.getOrDefault(num, 0L) + 1);
            preSum.put(num, preSum.getOrDefault(num, 0L) + i);

        }
        return arr;
    }
}