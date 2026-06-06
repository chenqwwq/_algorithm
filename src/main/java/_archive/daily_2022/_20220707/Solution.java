package top.chenqwwq.leetcode.daily._2022._20220707;

import java.util.List;

/**
 * @author 沽酒
 * @since 2022/07/07
 */
public class Solution {
    private Solution[] child = new Solution[26];
    private boolean end = false;

    public void insert(String word) {
        Solution node = this;
        for (char c : word.toCharArray()) {
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new Solution();
            }
            node = node.child[c - 'a'];
        }
        node.end = true;
    }

    public String find(String word) {
        Solution node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null) {
                break;
            }
            if (node.child[c - 'a'].end) {
                return word.substring(0, i + 1);
            }
            node = node.child[c - 'a'];
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }
        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split(" ")) {
            ans.append(find(word)).append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }
}