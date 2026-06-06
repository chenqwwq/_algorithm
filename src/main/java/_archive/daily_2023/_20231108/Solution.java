package top.chenqwwq.leetcode.daily._2023._20231108;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/11/8
 **/
public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        final int n = s.length();
        int ans = 0,pre = -1,cnt = 0;
        List<Integer> nums = new ArrayList<>();
        for(int i = 0;i < n;i++){
            final int cur = s.charAt(i) - '0';
            if(cur == pre)cnt++;
            else{
                if(cnt != 0) nums.add(cnt);
                cnt=1;
                pre = cur;
            }
        }
        nums.add(cnt);
        for(int i = s.charAt(0) == '0' ? 1 : 2;i < nums.size();i+=2){
            ans  = Math.max(ans,Math.min(nums.get(i-1),nums.get(i)) << 1);
        }
        return ans;
    }
}