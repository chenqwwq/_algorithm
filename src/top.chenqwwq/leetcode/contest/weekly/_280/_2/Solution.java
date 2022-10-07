package leetcode.weekly._280._2;

import java.util.*;

/**
 * @author chen
 * @date 2022/2/13
 **/
public class Solution {
    public int minimumOperations(int[] nums) {
        final int n = nums.length;
        if(n < 2){
            return 0;
        }
        Map<Integer, Integer> odd = new HashMap<>(), even = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            } else {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> e1 = new ArrayList<>(odd.entrySet()), e2 = new ArrayList<>(even.entrySet());
        e1.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        e2.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        if (!Objects.equals(e1.get(0).getKey(), e2.get(0).getKey())) {
            return n - e1.get(0).getValue() - e2.get(0).getValue();
        }

        return n - Math.max(e1.get(0).getValue() + (e2.size() > 1 ? e2.get(1).getValue() : 0),
                (e1.size() > 1 ? e1.get(1).getValue() : 0) + e2.get(0).getValue());
    }
}