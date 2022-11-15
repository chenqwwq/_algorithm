package top.chenqwwq.leetcode.daily._202211;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/11/15
 **/
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        final int n = boxTypes.length;
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int ans = 0;
        for (int i = 0; i < n && truckSize > 0; ) {
            while (i < n && boxTypes[i][0] <= 0) i++;
            if (i > n) break;
            boxTypes[i][0]--;
            ans += boxTypes[i][1];
            truckSize--;
        }
        return ans;
    }
}