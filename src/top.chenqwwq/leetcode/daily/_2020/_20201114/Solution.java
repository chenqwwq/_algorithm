package top.chenqwwq.leetcode.daily._2020._20201114;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @author chen
 * @date 2020/11/14
 **/
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        // 统计arr1的数字
        int[] hash = new int[1001];
        for (int i : arr1) {
            hash[i]++;
        }
        int[] ans = new int[arr1.length];
        int idx = 0;

        for (int i : arr2) {
            while (hash[i]-- > 0) {
                ans[idx++] = i;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (hash[i]-- > 0) {
                ans[idx++] = i;
            }
        }

        return ans;
    }
}
