package top.chenqwwq.leetcode.daily._20201025;

/**
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author chen
 * @date 2020/10/25
 **/
public class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // 求出每个节点左右扩展的长度
        int length = A.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 0;
        for (int i = 1; i < length; i++) {
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 0;
        }
        right[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = A[i] > A[i + 1] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(left[i] + right[i] + 1, ans);
            }
        }

        return ans;
    }
//    public int longestMountain(int[] A) {
//        if (A == null || A.length < 3) {
//            return 0;
//        }
//        // 中点扩张
//        int ans = 0;
//        for (int i = 1; i < A.length - 1; i++) {
//            int li = i - 1, ri = i + 1;
//            int l = A[i], r = A[i];
//            int tmp = 1;
//            while (li >= 0 && ri < A.length && A[li] < l && A[ri] < r) {
//                l = A[li--];
//                r = A[ri++];
//                tmp += 2;
//            }
//            if(ri != i+1) {
//                while (li >= 0 && l > A[li]) {
//                    tmp++;
//                    l = A[li--];
//                }
//            }
//            if(li != i - 1) {
//                while (ri < A.length && r > A[ri]) {
//                    tmp++;
//                    r = A[ri++];
//                }
//            }
//            if (tmp != 1 && tmp > ans) {
//                ans = tmp;
//            }
//        }
//
//        return ans;
//    }
}
