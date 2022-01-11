package top.chenqwwq.leetcode.weekly._213._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2020/11/1
 **/
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 用pieces的第一个元素作hash
        Map<Integer, int[]> hash = new HashMap<>();
        for (int[] piece : pieces) {
            hash.put(piece[0], piece);
        }

        int idx = 0;
        while (idx < arr.length) {
            int[] ints = hash.get(arr[idx]);
            if (ints == null) {
                return false;
            }
            for (int i : ints) {
                if (i != arr[idx++]) {
                    return false;
                }
            }
        }

        return true;
    }
}