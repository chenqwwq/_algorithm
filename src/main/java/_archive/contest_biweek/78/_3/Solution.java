package top.chenqwwq.leetcode.contest.biweek._78._3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/5/14
 **/
public class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
        int n = tiles.length, l = 0, r = 0, sum = 0, max = 0;
        while (l <= r && r < n) {
            int leftBoundary = tiles[l][0], rightBoundary = leftBoundary + carpetLen - 1;
            //未覆盖完
            if (tiles[r][1] <= rightBoundary) {
                sum += tiles[r][1] - tiles[r][0] + 1;
                r++;
                max = Math.max(sum, max);
            } else {
                //覆盖部分
                if(rightBoundary >= tiles[r][0]){
                    max = Math.max(sum + rightBoundary - tiles[r][0] + 1, max);
                }
                //调整到下一个区间开头
                sum -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }
        }
        return max;
    }
}