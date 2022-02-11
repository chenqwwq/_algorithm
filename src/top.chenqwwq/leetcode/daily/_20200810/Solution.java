package top.chenqwwq.leetcode.daily._20200810;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符
 *
 * @author chen
 * @date 2020/8/10 下午11:04
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> cntList = new ArrayList<>();
        int cnt = 0;
        char cur = '0';
        // 求出相邻的0,1
        for (char i : s.toCharArray()) {
            if (cur != i) {
                cntList.add(cnt);
                cur = i;
                cnt = 1;
                continue;
            }
            cnt++;
        }
        cntList.add(cnt);

        int res = 0;
        for (int i = 0; i < cntList.size() - 1; i++) {
            res += Math.min(cntList.get(i), cntList.get(i + 1));
        }

        return res;
    }
}