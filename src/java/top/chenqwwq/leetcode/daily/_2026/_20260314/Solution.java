package top.chenqwwq.leetcode.daily._2026._20260314;

/**
 * @author chenqwwq
 * @date 2026/3/14
 **/
public class Solution {

    char[] cs = new char[]{'a', 'b', 'c'};
    String ans = "";
    int k;

    public static void main(String[] args) {
        new Solution().getHappyString(3, 9);
    }

    public String getHappyString(int n, int k) {
        this.k = k;
        ans = "";
        dfs(new StringBuilder(), n);
        return ans;
    }

    public void dfs(StringBuilder cur, int n) {
        if (ans != "") return;
        if (cur.length() == n) {
            if (--k == 0) {
                ans = cur.toString();
            }
            return;
        }


        for (char c : cs) {
            if (!cur.isEmpty() && c == cur.charAt(cur.length() - 1)) continue;
            cur.append(c);
            dfs(cur, n);
            if (ans != "") return;
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}