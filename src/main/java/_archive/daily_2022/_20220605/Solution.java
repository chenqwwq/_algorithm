package top.chenqwwq.leetcode.daily._2022._20220605;

import java.util.Random;

/**
 * @author chenqwwq
 * @date 2022/6/5
 **/
public class Solution {
    double r, x, y;
    Random random = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
//        double len = Math.sqrt(random.nextDouble(r * r)), ang = random.nextDouble(2 * Math.PI);
//        double nx = x + len * Math.cos(ang), ny = y + len * Math.sin(ang);
//        return new double[]{nx, ny};
        return null;
    }
}