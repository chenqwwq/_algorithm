package top.chenqwwq.leetcode.daily._2026._20260521;

/**
 * @author chenqwwq
 * @date 2026/5/23
 **/
public class Solution {
    class Node {
        Node[] childs;

        public Node() {
            this.childs = new Node[10];
        }

        public void insert(String s, int i) {
            if (i >= s.length()) return;
            if (childs[s.charAt(i) - '0'] == null) childs[s.charAt(i) - '0'] = new Node();
            childs[s.charAt(i) - '0'].insert(s, i + 1);
        }

        public int find(String s, int i) {
            if (i >= s.length()) return 0;
            final int idx = s.charAt(i) - '0';
            if (childs[idx] == null) return 0;
            return childs[idx].find(s, i + 1) + 1;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = new Node();
        for (int num : arr1) {
            root.insert(String.valueOf(num), 0);
        }

        int ans = 0;
        for (int num : arr2) {
            ans = Math.max(ans, root.find(String.valueOf(num), 0));
        }
        return ans;
    }

    public static void main(String[] args) {
        final int i = new Solution().longestCommonPrefix(new int[]{32, 33, 35}, new int[]{10, 12, 32});
        System.out.println(i);
    }
}