package top.chenqwwq.leetcode.daily._2023._20230603;

/**
 * @author chenqwwq
 * @date 2023/6/4
 **/
public class Solution {
    // WA
    public int maxRepOpt1(String text) {
        final int n = text.length();
        if (n <= 1) return n;
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            hash[text.charAt(i) - 'a']++;
        }
        int ans = 0;
        int l = 0, r = 0;
        while (l < n) {
            char a = ' ',b = ' ';
            int ca = 0,cb = 0;
            while (r < n) {
                final char c = text.charAt(r++);
                if(a == ' ' || a == c){
                    a = c;
                    ca++;
                }else if(b == ' ' || b == c){
                    b = c;
                    cb++;
                }else {
                    break;
                }
                if(ca > 1 && cb > 1) break;
            }

            l = r;
        }
        return ans;
    }
}
