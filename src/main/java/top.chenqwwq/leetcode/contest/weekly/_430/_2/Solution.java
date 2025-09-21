package top.chenqwwq.leetcode.contest.weekly._430._2;

/**
 * @author chenqwwq
 * @date 2024/12/29
 **/
public class Solution {
    public String answerString(String word, int c) {
        if (c == 1) return word;
        final int n = word.length();
        // 分了c组,最大长度为 word.length() - c + 1
        int m = n - c + 1;
        int[] ans = {0, Math.min(m - 1, n - 1)};
        for (int i = 1; i < n; i++) {
            ans = comp(word, ans, new int[]{i, Math.min(i + m - 1, n - 1)});
        }
        return word.substring(ans[0], ans[1]+1);
    }

    public int[] comp(String word, int[] i, int[] j) {
        final int n = word.length();
        for (int q = i[0], p = j[0]; q <= i[1] || p < j[1]; q++, p++) {
            if (q > i[1]) return j;
            if (p > j[1]) return i;
            if (word.charAt(q) > word.charAt(p)) return i;
            if (word.charAt(q) < word.charAt(p)) return j;

        }
        return i;
    }

    public static void main(String[] args) {
        new Solution().answerString("aann", 2);
    }
}