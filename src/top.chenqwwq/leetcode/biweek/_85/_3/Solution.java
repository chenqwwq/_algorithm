package top.chenqwwq.leetcode.biweek._85._3;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLOperation;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/8/20
 **/
public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        final int n = s.length();
        int[] diff = new int[n + 1];
        for (int[] shift : shifts) {
            diff[shift[0]] += (shift[2] == 0 ? -1 : 1);
            diff[shift[1] + 1] -= (shift[2] == 0 ? -1 : 1);
        }
        int num = 0;
        for (int i = 0; i <= n; i++) {
            num += diff[i];
            diff[i] = num;
        }

        System.out.println(Arrays.toString(diff));

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            diff[i] %= 26;
            int cur = sb.charAt(i) - 'a';
            cur = (cur + diff[i] + 26) % 26;
            sb.setCharAt(i, (char) (cur + 'a'));
        }
        return sb.toString();
    }
}
