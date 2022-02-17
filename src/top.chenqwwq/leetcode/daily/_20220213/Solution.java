package leetcode.daily.daily._20220213;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2022/2/13
 **/
public class Solution {
    public int maxNumberOfBalloons(String text) {
        // balloon
        Map<Character, Integer> hash = new HashMap<>();
        for (char c : text.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        return min(hash.getOrDefault('b', 0), hash.getOrDefault('a', 0), hash.getOrDefault('l', 0) >> 1, hash.getOrDefault('o', 0) >> 1,
                hash.getOrDefault('n', 0));
    }

    private int min(int... nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            ans = Math.min(ans, num);
        }
        return ans;
    }
}