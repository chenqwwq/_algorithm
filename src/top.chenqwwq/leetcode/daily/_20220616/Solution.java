package top.chenqwwq.leetcode.daily._20220616;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/6/17
 **/
public class Solution {
    public void duplicateZeros(int[] arr) {
        final int n = arr.length;

        int i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        i--;
        j--;
        while (i >= 0){
            if(j < n){
                arr[j] = arr[i];
            }
            if(arr[i] == 0 && --j >= 0){
                arr[j] = 0;
            }
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        new Solution().duplicateZeros(new int[]{1, 2, 3});
        new Solution().duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }
}