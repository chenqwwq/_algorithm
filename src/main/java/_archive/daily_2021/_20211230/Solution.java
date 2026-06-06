package top.chenqwwq.leetcode.daily._2021._20211230;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/30
 **/
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int n = hand.length, m = n / groupSize;
        if (n % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : hand) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        final ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hash.entrySet());
        entries.sort(Comparator.comparingInt(Map.Entry::getKey));

        for (int i = 0; i < m; i++) {
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() == 0) {
                    continue;
                }
                final int start = entry.getKey();
                for (int j = 0; j < groupSize; j++) {
                    final int target = hash.getOrDefault(start + j, 0) - 1;
                    if(target < 0){
                        return false;
                    }
                    hash.put(start+j,target);
                }
                break;
            }
        }
        return true;
    }
}
