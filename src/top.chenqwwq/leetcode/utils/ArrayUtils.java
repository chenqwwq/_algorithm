package top.chenqwwq.leetcode.utils;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020/4/25 下午3:38
 */
public class ArrayUtils {
    public static boolean arrEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int idx = 0;
        while (idx < arr1.length) {
            if (arr1[idx] != arr2[idx]) {
                return false;
            }
            idx++;
        }

        return true;
    }

    public static boolean arrEqual(double[] arr1, double[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int idx = 0;
        while (idx < arr1.length) {
            if (arr1[idx] != arr2[idx]) {
                return false;
            }
            idx++;
        }

        return true;
    }

    public static boolean arrEqual(int[][] arr1, int[][] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }

        int idx = 0;
        while (idx < arr1.length) {
            if (!arrEqual(arr1[idx], arr2[idx])) {
                return false;
            }
            idx++;
        }

        return false;
    }


}
