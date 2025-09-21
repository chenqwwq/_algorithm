package top.chenqwwq.leetcode.archive.$20200418.by_topics.sort;

/**
 * 快速排序：
 * 单轴快排,递归形式
 *
 * @author bingxin.chen
 * @date 2019/10/16 17:23
 */
public class SinglePivotQuickSortRecursive implements SortInterface {

    private void recursive(int[] arr, int left, int right) {
        // 数据异常就退出
        if (left >= right) {
            return;
        }

        // 以最左边的元素作为中轴
        int axis = arr[left];

        // 两端交换,最后交换中轴数
        int i = left + 1, j = right;
        while (i <= j) {
            // 从左往右找到第一个比中轴数大的数
            while (i <= j && arr[i] <= axis) {
                i++;
            }

            // 从右往左找到第一个比中轴数小的数字
            while (i <= j && arr[j] > axis) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // 交换中轴数
        swap(arr, left, j);
        // 递归左右代码
        recursive(arr, left, j - 1);
        recursive(arr, j + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];


//        final int i1 = arr[i];
//        arr[i] = arr[j];
//        arr[j] = i1;

    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        this.recursive(arr, 0, arr.length - 1);
    }
}
