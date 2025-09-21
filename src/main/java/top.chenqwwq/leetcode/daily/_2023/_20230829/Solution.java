package top.chenqwwq.leetcode.daily._2023._20230829;

import javax.swing.*;
import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/8/29
 **/
public class Solution {

    private static final int mod = (int) 1e9 + 7;

    Set<Integer> exist;
    Map<Integer, List<int[]>> map;
    Map<Integer, Integer> memo;

    public int numFactoredBinaryTrees(int[] arr) {
        final int n = arr.length;
        exist = new HashSet<>();
        map = new HashMap<>();
        memo = new HashMap<>();
        for (int num : arr) exist.add(num);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                final long tmp = (long) arr[i] * arr[j];
                if (tmp > Integer.MAX_VALUE) continue;
                int intTmp = (int) tmp;
                if (exist.contains(intTmp)) {
                    final List<int[]> ls = map.getOrDefault(intTmp, new ArrayList<>());
                    ls.add(new int[]{arr[i], arr[j]});
                    map.put(intTmp, ls);
                }
            }
        }

        long ans = 0;
        for (int num : arr) ans = (ans + handle(num)) % mod;
        return (int) ans;
    }

    public int handle(int num) {
        if (memo.containsKey(num)) return memo.get(num);
        long ans = 0;
        if (map.containsKey(num)) {
            for (int[] nums : map.get(num)) {
                final long c1 = handle(nums[0]), c2 = handle(nums[1]);
                if (nums[0] == nums[1]) ans = (int) (ans + c1 * c2 % mod) % mod;
                else ans = (int) (ans + c1 * c2 * 2 % mod) % mod;
            }
        }
        ans += 1;
        memo.put(num, (int) ans);
        return (int) ans;
    }
}