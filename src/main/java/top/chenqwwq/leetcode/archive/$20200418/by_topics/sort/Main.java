package top.chenqwwq.leetcode.archive.$20200418.by_topics.sort;

import java.util.Arrays;

/**
 * @author bingxin.chen
 * @date 2019/10/16 17:35
 */
public class Main {
    public static void main(String[] args) {
        final int[] ints = {8, 5, 6, 2, 7, 3, 1, 9};
        SortInterface sortInterface = new SinglePivotQuickSortRecursive();
        sortInterface.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
