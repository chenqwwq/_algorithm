package top.chenqwwq.leetcode.daily._2024._20241024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenqwwq
 * @date 2024/10/24
 **/
public class Solution {

    private int max(int...s){
        int max = -1,cur = -1;
        for(int i = 0;i < s.length;i++){
            if(s[i] > max){
                cur = i;
                max = s[i];
            }
        }
        return cur;
    }
    public int findWinningPlayer(int[] skills, int k) {
        final int n = skills.length;
        if(k > n) return max(skills);
        final Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            deque.addLast(i);
        }
        int cur = 0, cnt = 0;
        while (cnt < k) {
            final Integer fir = deque.pollFirst();
            if(skills[cur] > skills[fir]){
                cnt++;
                deque.addLast(fir);
            }else{
                cnt = 1;
                deque.addLast(cur);
                cur = fir;
            }
        }
        return cur;
    }
}