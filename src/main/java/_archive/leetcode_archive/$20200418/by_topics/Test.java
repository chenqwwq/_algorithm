package top.chenqwwq.leetcode.archive.$20200418.by_topics;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020/3/23 下午5:32
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test().merge(new int[]{0, 1, 2, 3}, new int[]{3, 2, 1})));
    }

    /**
     * @param arr1 升序
     * @param arr2 降序
     */
    public int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = arr2.length - 1;
        int[] res = new int[arr1.length + arr2.length];
        int index = 0;
        while (i < arr1.length && j >= 0) {
            if (arr1[i] < arr2[j]) {
                res[index++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                res[index++] = arr2[j--];
            } else {
                res[index++] = arr1[i++];
                res[index++] = arr2[j--];
            }
        }

        while (i < arr1.length) {
            res[index++] = arr1[i++];
        }

        while (j >= 0) {
            res[index++] = arr2[j--];
        }

        return res;
    }
}
