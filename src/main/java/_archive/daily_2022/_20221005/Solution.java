package top.chenqwwq.leetcode.daily._2022._20221005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/10/5
 **/
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Long> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] ss = s.split(" ");
            int cnt = Integer.parseInt(ss[0]);
            String domain = ss[1];
            map.put(domain, map.getOrDefault(domain, 0L) + cnt);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String key = domain.substring(i + 1);
                    map.put(key, map.getOrDefault(key, 0L) + cnt);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Long> entry : map.entrySet()){
            ans.add(entry.getValue() +" "+ entry.getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }
}