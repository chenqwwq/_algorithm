package top.chenqwwq.leetcode.topic.design._208;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * @author chen
 * @date 2020/7/9 下午10:26
 */
public class Trie {

    /**
     * 字符全部由小写字符构成
     */
    Trie[] child;

    /**
     * 是否是末尾，是否构成字符
     */
    boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.child = new Trie[26];
        this.isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie root = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (root.child[idx] == null) {
                root.child[idx] = new Trie();
            }
            root = root.child[idx];
        }

        root.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Trie root = this;
        for (char c : word.toCharArray()) {
            final int idx = c - 'a';
            if (root.child[idx] == null) {
                return false;
            }
            root = root.child[idx];
        }

        return root.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        Trie root = this;
        for (char c : prefix.toCharArray()) {
            final int idx = c - 'a';
            if (root.child[idx] == null) {
                return false;
            }
            root = root.child[idx];
        }

        return true;
    }

}
