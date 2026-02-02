package top.chenqwwq.leetcode.daily._2025._20251212;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2025/12/12
 **/
public class Solution {

    public int[] countMentions(int n, List<List<String>> es) {

        // 按照时间戳升序排列
        es.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (Objects.equals(o1.get(1), o2.get(1))) {
                    return o1.get(0).compareTo(o2.get(1));

                }
                return Integer.compare(Integer.parseInt(o1.get(1)), Integer.parseInt(o2.get(1)));
            }
        });

        // 用户开始活跃的时间（初始为 0
        final int[] ac = new int[n];
        final int[] ans = new int[n];
        for (List<String> e : es) {
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));
            String content = e.get(2);
            if (Objects.equals(type, "MESSAGE")) {
                if (Objects.equals(content, "ALL")) {
                    for (int i = 0; i < n; i++) {
                        ans[i]++;
                    }
                } else if (Objects.equals(content, "HERE")) {
                    for (int i = 0; i < n; i++) {
                        if (ac[i] <= time) {
                            ans[i]++;
                        }
                    }
                } else {
                    for (String c : content.split(" ")) {
                        ans[Integer.parseInt(c.substring(2))]++;
                    }
                }
            } else {
                int id = Integer.parseInt(content);
                ac[id] = Math.max(ac[id], time + 60);
            }
        }
        return ans;
    }
}