package top.chenqwwq.leetcode.daily._2025._20250923;

import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2025/9/23
 **/
public class Solution {
    public int compareVersion(String version1, String version2) {
        final String[] vs1 = version1.split("\\.");
        final String[] vs2 = version2.split("\\.");

        for (int i = 0; i < Math.max(vs1.length, vs2.length); i++) {
            String v1 = i < vs1.length ? vs1[i] : "0";
            String v2 = i < vs2.length ? vs2[i] : "0";
            final int x = Integer.parseInt(v1);
            final int y = Integer.parseInt(v2);
            if (!Objects.equals(x, y)) {
                return Integer.compare(x, y);
            }
        }
        return 0;
    }
}