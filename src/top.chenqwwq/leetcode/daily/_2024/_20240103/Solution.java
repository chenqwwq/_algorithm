package top.chenqwwq.leetcode.daily._2024._20240103;

import lombok.val;
import top.chenqwwq.leetcode.common.ListNode;


/**
 * @author chenqwwq
 * @date 2024/1/3
 **/
public class Solution {

    static class Pair{
        int val;
        ListNode node;
        public Pair(){}

        public static Pair of(int val,ListNode node){
            final Pair pair = new Pair();
            pair.val = val;
            pair.node = node;
            return pair;
        }
    }

    public ListNode removeNodes(ListNode head) {
        return remove(head).node;
    }


    private Pair remove(ListNode node){
        if(node == null) return Pair.of(0,null);
        final Pair pair = remove(node.next);
        if(node.val < pair.val) return pair;
        node.next = pair.node;
        return Pair.of(node.val,node);
    }
}