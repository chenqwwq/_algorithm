package top.chenqwwq.leetcode.weekly._291._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/5/1
 **/
public class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (!map.containsKey(card)) {
                map.put(card, new ArrayList<>());
            }
            map.get(card).add(i);
        }

        int ans = Integer.MAX_VALUE;
        for (List<Integer> vs : map.values()) {
            for (int i = 0; i < vs.size() - 1; i++) {
                ans = Math.min(ans, vs.get(i + 1) - vs.get(i) + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}