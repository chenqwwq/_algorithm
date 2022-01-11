package top.chenqwwq.leetcode.archive.$20200418.writte_exam.达西电商;

/**
 * @author chen
 * @date 2020/3/24 下午10:20
 */
public class $02 {
    public static void main(String[] args) {
        System.out.println(new $02().valid("internationalization", "i12iz4n"));
        System.out.println(new $02().valid("internationalization", "i12kz4n"));
        System.out.println(new $02().valid("apple", "a2e"));
        System.out.println(new $02().valid("apple", "a3e"));
    }

    public boolean valid(String word, String abbr) {
        final char[] wordChars = word.toCharArray();
        final char[] abbrChars = abbr.toCharArray();

        // i为word的下标
        // j为abbr的下标
        int i = 0, j = 0;

        while (i < wordChars.length && j < abbrChars.length) {
            // 0开头的数字,直接return掉
            // 也可以直接忽略
            if (abbrChars[j] == '0') {
                return false;
            }
            if (abbrChars[j] > '0' && abbrChars[j] <= '9') {
                // 如果是数字,获取附近全部的数字
                int num = abbrChars[j++] - '0';
                while (abbrChars[j] > '0' && abbrChars[j] <= '9') {
                    num = num * 10 + (abbrChars[j++] - '0');
                }
                i += num;
            } else {
                if (abbrChars[j++] != wordChars[i++]) {
                    return false;
                }
            }
        }

        return true;
    }
}
