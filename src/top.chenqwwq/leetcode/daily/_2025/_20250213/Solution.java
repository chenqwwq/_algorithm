package top.chenqwwq.leetcode.daily._2025._20250213;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/2/13
 **/
public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            Integer intSum = getIntSum(i);
            final Integer p = map.getOrDefault(intSum, 0);
            map.put(intSum, p + 1);
            ans = Math.max(ans, p + 1);
        }
        return ans;
        
    }

    public int getIntSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}