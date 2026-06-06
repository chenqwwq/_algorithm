package top.chenqwwq.leetcode.contest.biweek._152._3;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/15
 **/
public class Solution {

    static class Node {
        int val;
        Map<Character, Node> childs;

        public Node(int val) {
            this.val = val;
            this.childs = new HashMap<>();
        }

        public void add(String str, int idx) {
            if (idx >= str.length()) return;
            final char ch = str.charAt(idx);
            if (childs.containsKey(ch)) {
                childs.get(ch).val++;
            } else {
                childs.put(ch, new Node(1));
            }
            childs.get(ch).add(str, idx + 1);
        }

        public int find(int k, String str, int cur,boolean check) {
            if(check){
            }
            return 1;
        }
    }

    public int[] longestCommonPrefix(String[] words, int k) {
        return null;
    }
}