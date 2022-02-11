package top.chenqwwq.leetcode.archive.$20200418.writte_exam;

/**
 * @author chen
 * @date 2019/11/27 下午5:14
 */
public class FaceExam {
    public int getFarZero(String s) {
        final int length = s.length();
        final char[] chars = s.toCharArray();
        int index = -1, maxLen = 0;
        int i = 0;

        for (; i < length; i++) {
            if (chars[i] == '1') {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (chars[j] == '1') {
                    if (maxLen < j - i) {
                        maxLen = j - i;
                        index = i == 0 ? 0 : (i + j - 1) >> 1;
                    }

                    i = j + 1;
                    break;
                }
            }
        }
        return index;
    }
}
