package top.chenqwwq.leetcode.contest.weekly._428._2;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2024/12/15
 **/
public class Solution {

    static class Node {
        String currency;

        double rate;

        Node(String currency, double rate) {
            this.currency = currency;
            this.rate = rate;
        }
    }


    public double maxAmount(String currency, List<List<String>> p1, double[] r1, List<List<String>> p2, double[] r2) {
        final Map<String, Node> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int i = 0; i < p1.size(); i++) {
            m1.put(p1.get(i).get(1), new Node(p1.get(i).get(0), r1[i]));
        }
        for (int i = 0; i < p2.size(); i++) {
            m2.put(p2.get(i).get(1), new Node(p2.get(i).get(0), r2[i]));
        }

        return Math.max(dfs(currency, 1.0, m1, m2, 0), dfs(currency, 1.0, m1, m2, 1));
    }

    public double dfs(String i, double cur, Map<String, Node> m1, Map<String, Node> m2, int day) {
        // 第一天
        double mmax = cur;
        if (day == 0) {

            // 不转换直接跳到第二天
            mmax = Math.max(mmax, dfs(i, cur, m1, m2, 1));

            // 转换
            final Node node = m1.get(i);
            if (Objects.nonNull(node)) {
                // 继续第一天
                m1.remove(i);
                mmax = Math.max(mmax, dfs(node.currency, cur * node.rate, m1, m2, 0));
                m1.put(i,node);
                // 跳到第二天
                mmax = Math.max(mmax, dfs(node.currency, cur * node.rate, m1, m2, 1));
            }

        } else {
            if (m2.containsKey(i)) {
                final Node node = m2.get(i);
                m2.remove(i);
                // 继续第二天
                mmax = Math.max(mmax, dfs(node.currency, cur * node.rate, m1, m2, 1));
                m2.put(i,node);
            }
        }
        return mmax;
    }
}