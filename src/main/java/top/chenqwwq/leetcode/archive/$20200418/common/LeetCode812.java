package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/29 11:20
 */
public class LeetCode812 {
    public static void main(String[] args) {
        int[][] i = new int[5][2];
        i[0] = new int[]{0, 0};
        i[1] = new int[]{0, 1};
        i[2] = new int[]{1, 0};
        i[3] = new int[]{0, 2};
        i[4] = new int[]{2, 0};

        System.out.println(new Solution().largestTriangleArea(i));
    }

    static class Solution {
        public double largestTriangleArea(int[][] points) {
            double max = -1d;

            int length = points.length;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = j + 1; k < length; k++) {
                        max = Math.max(max, getSpaceSize(points[i], points[j], points[k]));
                    }
                }
            }
            return max;
        }

        private double getSpaceSize(int[] point1, int[] point2, int[] point3) {
            double a = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
            double b = Math.sqrt(Math.pow(point2[0] - point3[0], 2) + Math.pow(point2[1] - point3[1], 2));
            double c = Math.sqrt(Math.pow(point3[0] - point1[0], 2) + Math.pow(point3[1] - point1[1], 2));
            if (!isValidTriangle(a, b, c)) {
                return -1;
            }
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        private boolean isValidTriangle(double a, double b, double c) {
            return a + b > c && b + c > a && c + a > b;
        }
    }
}
