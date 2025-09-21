package top.chenqwwq.leetcode.topic.array._88;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author chen
 * @date 2020/6/13 下午2:53
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 看了示例之后感觉不对
        /*
            nums1 = [1,2,3,0,0,0], m = 3
            nums2 = [2,5,6],       n = 3
         */
        // 很明显0会造成误判，
        // 这里只要求有序，可以直接从后面开始将选中的数字直接填充到nums1尾部

        // 开始填充的位置
        int i = m-- + --n;

        while (n >= 0 && m >= 0) {
            nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }

    }
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (nums2 == null || nums2.length == 0) {
//            return;
//        }
//
//        int[] res = new int[m + n];
//        int i = 0,j = 0,idx = 0;
//        while (i < nums1.length && j < nums2.length){
//            if(nums1[i] <= nums2[j]){
//                res[idx++] = nums1[i++];
//            }
//            if(nums1[i] >= nums2[j]){
//                res[idx++] = nums2[j++];
//            }
//        }
//
//        while (i < nums1.length){
//            res[idx++] = nums1[i++];
//        }
//
//        while (j < nums2.length){
//            res[idx++] = nums2[j++];
//        }
//
//        nums1 = res;
//    }
}
