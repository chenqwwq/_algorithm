package top.chenqwwq.leetcode.daily._2023._20230626;

/**
 * @author 沽酒
 * @since 2023/06/26
 */
public class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        int sum = (1 + n) * (n / 2);
        int cur = 0;
        for(int i = 1;i < n;i++){
            if(sum - cur == cur + i) return i;
            cur += i;
        }
        return -1;
    }

}