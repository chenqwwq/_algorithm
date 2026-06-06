package top.chenqwwq.leetcode.topic.tree._720;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * 注意:
 * <p>
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 *
 * @author chen
 * @date 2020/7/12 下午3:28
 */
public class Solution {

    public String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // 构建前缀树
        Trie trie = new Trie();
        // 方便判断
        // 因为字母都要由别的字母逐渐增加一个字母来组成
        trie.isEnd = true;
        String res = "";
        for (String s : words) {
            final boolean insert = trie.insert(s);
            if (insert) {
                if (res.length() < s.length()) {
                    res = s;
                }
                if (res.length() == s.length()) {
                    final String[] a = {res, s};
                    Arrays.sort(a);
                    res = a[0];
                }
            }
        }

        return res;
    }

    class Trie {
        Trie[] child;

        boolean isEnd;

        public Trie() {
            child = new Trie[26];
            isEnd = false;
        }

        /**
         * 插入单词
         */
        public boolean insert(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            // 以当前节点为Root
            Trie curr = this;
            for (char c : word.toCharArray()) {
                if (!curr.isEnd) {
                    return false;
                }
                final int idx = c - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new Trie();
                }
                curr = curr.child[idx];
            }
            curr.isEnd = true;
            return true;
        }
    }
}
