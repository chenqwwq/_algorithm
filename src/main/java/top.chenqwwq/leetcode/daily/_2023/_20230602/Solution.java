package top.chenqwwq.leetcode.daily._2023._20230602;

/**
 * @author 沽酒
 * @since 2023/06/02
 */
public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        final int n = words.length, m = queries.length;
        int[] ss = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ss[i + 1] = ss[i] + get(words[i]);
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = ss[queries[i][1]+1] - ss[queries[i][0]];
        }
        return ans;
    }

    boolean[] vowels = new boolean[26];

    {
        vowels['a' - 'a'] = true;
        vowels['e' - 'a'] = true;
        vowels['i' - 'a'] = true;
        vowels['o' - 'a'] = true;
        vowels['u' - 'a'] = true;
    }


    public int get(String word) {
        return vowels[word.charAt(0) - 'a'] && vowels[word.charAt(word.length() - 1) - 'a'] ? 1 : 0;
    }
}