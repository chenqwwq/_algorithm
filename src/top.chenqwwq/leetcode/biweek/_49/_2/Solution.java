package top.chenqwwq.leetcode.biweek._49._2;

/**
 * @author chen
 * @date 2021/4/3
 **/
public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] src, des;
        if (sentence1.length() < sentence2.length()) {
            src = sentence1.split(" ");
            des = sentence2.split(" ");
        } else {
            src = sentence2.split(" ");
            des = sentence1.split(" ");
        }


        boolean flag = false;
        int i = 0, j = 0;
        for (; i < src.length && j < des.length; i++, j++) {
            if (!src[i].equals(des[j])) {
                if (flag) {
                    return false;
                }
                flag = true;
                // find next equals or the end of the string array
                while (j < des.length && !src[i].equals(des[j])) {
                    j++;
                }
            }
        }
        return i == src.length && j == des.length || (!flag && (i == src.length || j == des.length));
    }
}
