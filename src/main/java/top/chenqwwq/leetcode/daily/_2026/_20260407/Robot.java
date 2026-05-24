package top.chenqwwq.leetcode.daily._2026._20260407;

/**
 * @author chenqwwq
 * @date 2026/4/7
 **/
public class Robot {

    String[] dirs = new String[]{"East", "North", "West", "South"};

    int x, y, d;
    int mx, my;

    public Robot(int width, int height) {
        this.mx = width;
        this.my = height;
        this.x = 0;
        this.y = 0;
        this.d = 0;
    }

    public void step(int num) {
        if (num == 0) return;
        switch (d) {
            case 0:
                int step = Math.min(num, mx - 1 - x);
                x += step;
                num -= step;
                break;
            case 1:
                step = Math.min(num, my - 1 - y);
                y += step;
                num -= step;
                break;
            case 2:
                step = Math.min(num, x);
                x -= step;
                num -= step;
                break;
            case 3:
                step = Math.min(num, y);
                y -= step;
                num -= step;
                break;
        }
        if (num != 0) {
            d = (d + 1) % 4;
            step(num);
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirs[d];
    }
}