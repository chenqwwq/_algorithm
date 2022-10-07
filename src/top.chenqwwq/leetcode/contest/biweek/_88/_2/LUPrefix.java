package top.chenqwwq.leetcode.contest.biweek._88._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/10/7
 **/
public class LUPrefix {
    // 维护最小值，上传的时候动态更新就好

    int min = 0, n = 0;
    Set<Integer> vis = new HashSet<>();

    public LUPrefix(int n) {
        this.n = n;
    }

    public void upload(int video) {
        vis.add(video);
        while (vis.contains(min + 1)) min++;
    }

    public int longest() {
        return min;
    }
}
