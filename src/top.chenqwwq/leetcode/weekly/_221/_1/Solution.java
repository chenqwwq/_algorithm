package top.chenqwwq.leetcode.weekly._221._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2020/12/27
 **/
public class Solution {

    public boolean halvesAreAlike(String s) {
        // init
        Set<Character> hash = new HashSet<>();
        hash.add('a');
        hash.add('e');
        hash.add('i');
        hash.add('o');
        hash.add('u');
        hash.add('A');
        hash.add('E');
        hash.add('I');
        hash.add('O');
        hash.add('U');

        int length = s.length(), cnt = 0, i = 0;
        for (; i < length >> 1; i++) {
            if (hash.contains(s.charAt(i))) {
                cnt++;
            }
        }
        for (; i < length; i++) {
            if (hash.contains(s.charAt(i))) {
                cnt--;
            }
        }

        return cnt == 0;
    }
}
