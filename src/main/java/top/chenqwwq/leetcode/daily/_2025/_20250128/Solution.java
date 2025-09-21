package top.chenqwwq.leetcode.daily._2025._20250128;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/1/29
 **/
public class Solution {
    private static final List<Integer>[] c = new List[34];

    static {
        c[0] = List.of(1);
        for (int i = 1; i < c.length; i++) {
            List<Integer> row = new ArrayList<>(i + 1); // 预分配空间
            row.add(1);
            for (int j = 1; j < i; j++) {
                // 左上方的数 + 正上方的数
                row.add(c[i - 1].get(j - 1) + c[i - 1].get(j));
            }
            row.add(1);
            c[i] = row;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return c[rowIndex];
    }
}