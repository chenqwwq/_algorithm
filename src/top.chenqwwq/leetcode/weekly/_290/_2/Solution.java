package top.chenqwwq.leetcode.weekly._290._2;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/4/24
 **/
public class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Integer> s = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], d = circle[2];
            int l = x - d, r = x + d;
            int b = y - d, t = y + d;
            for (int i = l; i <= r; i++) {
                for (int j = b; j <= t; j++) {
                    if ((i - x) * (i - x) + (j - y) * (j - y) <= d * d) {
                        s.add(i * 10000 + j);
                    }
                }
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        new Solution().countLatticePoints(new int[][]{{2,2,1}});
    }
}
