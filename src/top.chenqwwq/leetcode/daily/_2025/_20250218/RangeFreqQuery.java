package top.chenqwwq.leetcode.daily._2025._20250218;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/2/18
 **/
public class RangeFreqQuery {

    private Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            final int key = arr[i];
            if (!map.containsKey(key)) {
                final List<Integer> ls = new ArrayList<>();
                ls.add(Integer.MIN_VALUE);
                map.put(key, ls);
            }
            final List<Integer> vals = map.get(key);
            vals.add(i);
            map.put(key, vals);
        }
        for (List<Integer> ls : map.values()) {
            ls.add(Integer.MAX_VALUE);
        }
    }

    public int query(int left, int right, int value) {
        final List<Integer> vals = map.get(value);
        if (vals == null) return 0;
        // 二分查找 vals 中的下标

        // 查找第一个大于等于 left 的下标
        final int l = floor(vals, left);
        // 查找第一个大于等于 right+1 大的下表
        final int r = floor(vals, right + 1);
        return r - l;
    }

    private static int floor(List<Integer> ls, int target) {
        int l = 0, r = ls.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int num = ls.get(mid);
            if (num >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }

}