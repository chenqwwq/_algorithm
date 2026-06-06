package top.chenqwwq.leetcode.daily._2022._20221002;

/**
 * @author chenqwwq
 * @date 2022/10/2
 **/
public class Solution {
    public boolean canTransform(String start, String end) {
        final int n = start.length();
        if (end.length() != n) return false;
        int[] idx1 = new int[n], idx2 = new int[n];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) != 'X') idx1[x++] = i;
            if (end.charAt(i) != 'X') idx2[y++] = i;
        }
        if(x != y) return false;
        for(int i = 0;i < x;i++){
            if(start.charAt(idx1[i]) != end.charAt(idx2[i])) return false;
            if(start.charAt(idx1[i]) == 'R' && idx1[i] > idx2[i]) return false;
            if(end.charAt(idx2[i]) == 'L' && idx2[i] < idx1[i]) return false;
        }
        return true;
    }
}