package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 6. Zigzag Conversion
 *
 * @author chen
 * @date 19-6-20 上午8:14
 */
public class LeetCode6 {

    public static void main(String[] args) {
        System.out.println(new LeetCode6().new Solution().convert("A", 1));
    }

    class Solution {
        public String convert(String s, int numRows) {
            // 题目有点意思啊...
            // 一开始以为是字符串带数组的问题,
            // 后面发现找到规律之后不需要真的排出Z型二维数组

            // 1. 排除特殊情况
            if (s == null || s.length() == 0) {
                return "";
            }
            if (s.length() <= numRows || numRows == 1) {
                return s;
            }
            char[] chars = s.toCharArray();

            StringBuilder stringBuilder = new StringBuilder();
            // 间隔的字符串个数,最大为2 * numRow - 2
            int interval = 2 * numRows - 2, len = interval;
            // 从上往下处理
            for (int i = 0; i < numRows; i++) {
                // index表示字符下标
                int index = i;
                // flag表示
                boolean flag = true;
                while (index < chars.length) {
                    stringBuilder.append(chars[index]);
                    index += interval != len ? (flag ? interval : len - interval) : interval;
                    flag = !flag;
                }

                interval = interval == 2 ? 2 * numRows - 2 : interval - 2;
            }

            return stringBuilder.toString();
            // 感觉上还是数组的边界判断问题
//            int length = s.length() % (2 * numRows - 2);
//            char[][] res = new char[numRows][length];
//
//            int i = 0, j = 0;
//            int q = 0;
//            while (q < chars.length){
//                while (q < chars.length && i <= numRows){
//                    res[i++][j] = chars[q++];
//                }
//
//                i = numRows-1;
//                while (q < chars.length && i >= 0){
//                    res[i--][j+1] = chars[q++];
//                }
//                i = 0;
//            }
//
//            StringBuilder
        }
    }
}
