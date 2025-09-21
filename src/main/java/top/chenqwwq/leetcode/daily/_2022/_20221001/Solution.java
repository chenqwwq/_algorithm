package top.chenqwwq.leetcode.daily._2022._20221001;

/**
 * @author chenqwwq
 * @date 2022/10/1
 **/
public class Solution {
    public String reformatNumber(String number) {
        number = number.replace(" ", "")
                .replace("-", "");
        StringBuilder ans = new StringBuilder();
        final int n = number.length();
        int i = 0;
        while (i < n - 4) {
            for (int j = 0; j < 3; j++) ans.append(number.charAt(i+j));
            ans.append('-');
            i += 3;
        }
        if (n - i == 2) ans.append(number, n - 2, n);
        if (n - i == 3) ans.append(number, n - 3, n);
        if (n - i == 4) {
            ans.append(number, n - 4, n - 2)
                    .append('-')
                    .append(number, n - 2, n);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        new Solution().reformatNumber("123 4-567");
    }
}