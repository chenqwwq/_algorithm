package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 756. 金字塔转化矩阵
 * <p>
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示，例如 “Z”。
 * <p>
 * 使用三元组表示金字塔的堆砌规则如下：
 * <p>
 * (A, B, C) 表示，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 * <p>
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 * <p>
 * 如果可以由基层一直堆到塔尖返回true，否则返回false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * 输出: true
 * 解析:
 * 可以堆砌成这样的金字塔:
 * A
 * / \
 * D   E
 * / \ / \
 * X   Y   Z
 * <p>
 * 因为符合('X', 'Y', 'D'), ('Y', 'Z', 'E') 和 ('D', 'E', 'A') 三种规则。
 * 示例 2:
 * <p>
 * 输入: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 * 输出: false
 * 解析:
 * 无法一直堆到塔尖。
 * 注意, 允许存在三元组(A, B, C)和 (A, B, D) ，其中 C != D.
 * 注意：
 * <p>
 * bottom 的长度范围在 [2, 8]。
 * allowed 的长度范围在[0, 200]。
 * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * // 1. 回溯超时
 *
 * @author chen
 * @date 2019/8/1 上午7:38
 */
public class LeetCode756 {
    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            if (bottom == null || bottom.length() == 0) {
                return false;
            }
            // 考虑回溯解法
            // 拆分为Map
            Map<String, List<String>> map = new HashMap<>();
            for (String s : allowed) {
                String substring = s.substring(0, 2);
                List<String> orDefault = map.getOrDefault(substring, new ArrayList<>());
                orDefault.add(s.substring(2));
                map.put(substring, orDefault);
            }

            return dfs(bottom, 0, new StringBuilder(), map);
        }

        private boolean dfs(String bottom, int start, StringBuilder sb, Map<String, List<String>> map) {
            if (bottom.length() == 1) {
                return true;
            }
            // 第一层回溯,回bottom
            String key = bottom.substring(start, start + 2);
            if (!map.containsKey(key)) {
                return false;
            }
            List<String> list = map.get(key);
            for (String o : list) {
                sb.append(o);
                boolean flag;
                if (start >= bottom.length() - 2) {
                    flag = dfs(sb.toString(), 0, new StringBuilder(), map);
                } else {
                    flag = dfs(bottom, start + 1, sb, map);
                }
                // 为true直接返回
                if (flag) {
                    return true;
                }
                // 为false 进行回溯
                // 跳回的地方很关键
                sb.delete(sb.length() - 1, sb.length());
            }
            return false;
        }
    }

}
