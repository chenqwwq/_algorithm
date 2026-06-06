package top.chenqwwq.leetcode.daily._2023._20230625;

/**
 * @author 沽酒
 * @since 2023/06/25
 */
public class Solution {
    int radius, x, y;

    public boolean checkOverlap(int radius, int x, int y, int x1, int y1, int x2, int y2) {
        // 无法直接枚举四个端点
        this.radius = radius;
        this.x = x;
        this.y = y;
        return check(x1, y1) || check(x2, y2) || check(x1, y2) || check(x2, y1);
    }

    public boolean check(int a, int b) {
        return (x - a) * (x - a) + (y - b) * (y - b) <= radius * radius;
    }
}