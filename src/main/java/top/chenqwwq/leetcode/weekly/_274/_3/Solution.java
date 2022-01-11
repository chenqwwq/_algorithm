package top.chenqwwq.leetcode.weekly._274._3;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        final int n = asteroids.length;
        Arrays.sort(asteroids);
        long total = mass;
        int i = 0;
        for (; i < n; i++){
            if(asteroids[i] > total){
                break;
            }
            total += asteroids[i];
        }
        return i == n;
    }
}
