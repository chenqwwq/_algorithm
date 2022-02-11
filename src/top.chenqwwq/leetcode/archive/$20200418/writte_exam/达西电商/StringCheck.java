package top.chenqwwq.leetcode.archive.$20200418.writte_exam.达西电商;

/**
 * @author chen
 * @date 2019/11/25 下午9:07
 */
public class StringCheck {
    public boolean valid(String word, String abbr) {
        if (abbr == null || abbr.length() <= 0) {
            return false;
        }
        final int abbrLen = abbr.length();
        final int wordLen = word.length();

        // 转化,获得基础数据
        final char[] abbrArray = abbr.toCharArray();
        final char[] wordArray = word.toCharArray();

        // 可以双指针遍历
        // 感觉上可以考虑用栈,处理起来更明确一点

        // abbrIndex 为abbr的遍历指针
        // wordIndex 为word的遍历指针
        int abbrIndex = 0, wordIndex = 0;

        while (wordIndex < wordLen) {
            char currAbbr = abbrArray[abbrIndex++];

            // 屏蔽'0'的情况
            while (currAbbr == '0') {
                currAbbr = abbrArray[abbrIndex++];
            }

            // 字母情况
            if (currAbbr >= 'a' && currAbbr <= 'z') {
                if (currAbbr != wordArray[wordIndex]) {
                    return false;
                }
                wordIndex++;
                continue;
            }

            // 数字情况
            // 需要转化为int进行判断
            int i = currAbbr - '0';
            // 往后判断是否为数字
            while (abbrIndex < abbrLen && abbrArray[abbrIndex] >= '0' && abbrArray[abbrIndex] <= '9') {
                i = i * 10 + (abbrArray[abbrIndex++] - '0');
            }
            wordIndex += i;
        }


        return abbrIndex == abbrLen && wordIndex == wordLen;
    }

}
