package top.chenqwwq.leetcode.biweek._26._2;

import java.util.ArrayList;
import java.util.List;

/**
 * 5397. 最简分数 显示英文描述
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 * @author chen
 * @date 2020/5/16 下午10:49
 */
public class Solution {

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();

        if (n <= 1) {
            return res;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) != 1) {
                    continue;
                }
                res.add(j + "/" + i);
            }
        }

        return res;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}