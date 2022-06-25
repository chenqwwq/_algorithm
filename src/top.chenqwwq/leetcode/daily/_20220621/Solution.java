package top.chenqwwq.leetcode.daily._20220621;

/**
 * @author chenqwwq
 * @date 2022/6/21
 **/
public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}