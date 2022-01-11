package top.chenqwwq.leetcode.weekly._185._1;


import java.util.ArrayList;
import java.util.List;

/**
 * 5388. 重新格式化字符串
 * 题目难度Easy
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成
 *
 * @author chen
 * @date 2020/4/19 上午10:39
 */
public class Solution {
//    public String reformat(String s) {
//        final char[] chars = s.toCharArray();
//        // 期望标志,true为期望数字
//        boolean flag = !Character.isDigit(chars[0]);
//        int index = 1;
//
//        while (index < chars.length){
//            if(Character.isDigit(chars[index]) == flag){
//                index++;
//                flag = !flag;
//            }else{
//                while (index)
//            }
//        }

    public String reformat(String s) {
        final char[] chars = s.toCharArray();
        List<Character> charList = new ArrayList<>();
        List<Character> digitalList = new ArrayList<>();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                digitalList.add(c);
            } else {
                charList.add(c);
            }
        }
        if (Math.abs(charList.size() - digitalList.size()) > 1) {
            return "";
        }

        return mergeList(charList, digitalList);
    }

    private String mergeList(List<Character> list1, List<Character> list2) {
        StringBuilder string = new StringBuilder();
        int index = 0;
        while (index < list1.size() && index < list2.size()) {
            string.append(list1.get(index));
            string.append(list2.get(index++));
        }

        if (index < list1.size()) {
            return string.append(list1.get(index)).toString();
        }

        if (index < list2.size()) {
            return list2.get(index) + string.toString();
        }

        return string.toString();
    }
}






















