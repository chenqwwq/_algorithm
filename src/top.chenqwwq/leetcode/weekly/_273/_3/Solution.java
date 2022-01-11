package top.chenqwwq.leetcode.weekly._273._3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
class Solution {

    public long[] getDistances(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], t -> new ArrayList<>()).add(i);
        }
        long[] result = new long[arr.length];
        for (ArrayList<Integer> list : map.values()) {
            for (int i : list) {
                result[list.get(0)] += i - list.get(0);
            }
            for (int i = 1; i < list.size(); i++) {
                result[list.get(i)] = result[list.get(i - 1)] + (2 * i - list.size()) * (list.get(i) - list.get(i - 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
    }
    // 2 5 6
    // 7 4 5
}
