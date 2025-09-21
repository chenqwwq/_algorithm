package top.chenqwwq.leetcode.contest.weekly._319._1;

/**
 * @author chenqwwq
 * @date 2022/11/13
 **/
public class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15d,celsius * 1.80d + 32.00d};
    }
}
