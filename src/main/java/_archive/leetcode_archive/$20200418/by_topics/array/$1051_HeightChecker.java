package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

/**
 * 1051. Height Checker
 * Easy
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 *
 * @author bingxin.chen
 * @date 2019/10/15 12:30
 */
public class $1051_HeightChecker {
    class Solution {

        /**
         * @param heights
         * @return
         */
        public int heightChecker(int[] heights) {
            // 初始化桶101个
            int[] bucket = new int[101];

            // 元素遍历入桶
            // 0号桶实际是空着的
            for (int i : heights) {
                ++bucket[i];
            }

            // 返回值,当前桶的下标
            int res = 0, currIndex = 0;
            // 二次遍历
            for (int i : heights) {
                // 找到非空桶
                while (bucket[currIndex] == 0) {
                    ++currIndex;
                }

                if (currIndex != i) {
                    res++;
                }

                --bucket[currIndex];
            }
            return res;
        }

//        /**
//         * 使用Java的排序方法,然后对比每一位是否失序

//         */
//        public int heightChecker(int[] heights) {
//            if(heights == null || heights.length == 0){
//                return 0;
//            }
//            int res = 0;
//            int[] copyArray = new int[heights.length];
//            // 先排序
//            System.arraycopy(heights,0,copyArray,0,heights.length);
//            Arrays.sort(copyArray);
//
//            // 对比每一位判断是否失序
//            for (int i = 0;i < heights.length;i++){
//                if(copyArray[i] != heights[i]){
//                    res++;
//                }
//            }
//            return res;
//        }
    }
}
