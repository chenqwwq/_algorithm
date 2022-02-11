package top.chenqwwq.leetcode.daily._20201103;

/**
 * @author chen
 * @date 2020-11-03
 **/
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        boolean hasUp = false;
        boolean up = true;
        for (int i = 1; i < A.length; i++) {
            if (up) {
                if (A[i] < A[i - 1]) {
                    up = false;
                } else if (A[i] == A[i - 1]) {
                    return false;
                } else {
                    hasUp = true;
                }
            } else {
                if (A[i] >= A[i - 1]) {
                    return false;
                }
            }

        }
        return !up && hasUp;
    }
}