package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.*;

/**
 * 870.Advantage Shuffle
 *
 * @author chen
 * @date 19-6-20 下午10:53
 */
public class LeetCode870 {

    public static void main(String[] args) {
        System.out.println(new LeetCode870().new Solution().advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2}));
    }

    class Solution {
        public int[] advantageCount(int[] A, int[] B) {
            // 贪心算法,最佳解为A中最小值 > B中的最小值


            // 构造一个HashMap key:B中的数 value:数的下标
            int length = B.length;
            Map<Integer, List<Integer>> intMap = new HashMap<>(length);
            for (int i = 0; i < B.length; i++) {
                if (intMap.get(B[i]) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    intMap.put(B[i], list);
                    continue;
                }
                intMap.get(B[i]).add(i);
            }

            // 将两个数组升序排列
            Arrays.sort(A);
            Arrays.sort(B);

            int[] res = new int[length];
            Arrays.fill(res, 0);
            for (int i = 0, indexA = 0, max = length - 1; i <= max; indexA++) {
                if (A[indexA] > B[i]) {
                    res[intMap.get(B[i]).get(0)] = A[indexA];
                    intMap.get(B[i++]).remove(0);
                } else {
                    res[intMap.get(B[max]).get(0)] = A[indexA];
                    intMap.get(B[max--]).remove(0);
                }
            }
            return res;
        }
    }
}
