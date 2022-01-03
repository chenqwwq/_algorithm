package top.chenqwwq.leetcode.weekly._274._1;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
public class Solution {
    public boolean checkString(String s) {
        return s.indexOf('b') < 0 || s.lastIndexOf('a') < s.indexOf('b');
    }
}