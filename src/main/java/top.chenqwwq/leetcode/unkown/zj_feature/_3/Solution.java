package top.chenqwwq.leetcode.unkown.zj_feature._3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 沽酒
 * @since 2022/07/08
 */
public class Solution {
    public int buildTransferStation(int[][] area) {
        final int n = area.length, m = area[0].length;

        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 1) {
                    l1.add(i);
                    l2.add(j);
                }
            }
        }

        l1.sort(Integer::compareTo);
        l2.sort(Integer::compareTo);
        int ans = 0, t = l1.get(l1.size() >> 1);
        for (int num : l1) {
            ans += Math.abs(num - t);
        }
        t = l2.get(l2.size() >> 1);
        for(int num : l2){
            ans += Math.abs(num - t);
        }
        return ans;
    }
}