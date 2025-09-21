package top.chenqwwq.leetcode.unkown.zj_feature._2;

/**
 * @author 沽酒
 * @since 2022/07/08
 */
public class Solution {
    public int minSwaps(int[] chess) {
        final int n = chess.length;
        int cnt = 0;
        for (int num : chess) {
            cnt += num;
        }
        if(cnt < 2){
            return 0;
        }
        int max = 0, sum = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += chess[r];
            while (r - l + 1 >= cnt) {
                max = Math.max(sum, max);
                sum -= chess[l++];
            }
        }
        return cnt - max;
    }
}