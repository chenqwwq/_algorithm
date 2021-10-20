package top.chenqwwq.leetcode.daily._20211019;

import java.util.HashMap;

/**
 * @author chen
 * @date 2021-10-19
 **/
public class WordDictionary {

	class TrieNode extends HashMap<Character, TrieNode> {
		boolean isEnd = false;
	}

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.containsKey(c)) {
				curr = curr.get(c);
			} else {
				TrieNode node = new TrieNode();
				curr.put(c, node);
				curr = node;
			}
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		return search(root, word, 0);
	}

	public boolean search(TrieNode node, String word, int i) {
		if (word.length() == i) {
			return node.isEnd;
		}
		final char c = word.charAt(i);
		if (c == '.') {
			for (TrieNode next : node.values()) {
				if (search(next, word, i + 1)) {
					return true;
				}
			}
			return false;
		}
		final TrieNode next = node.get(c);
		return next != null && search(next, word, i + 1);
	}
}