package top.chenqwwq.leetcode.daily._20220210;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2022-02-10
 **/
public class Solution {

    public static int gcd_division_recursive(int a,int b){
        return b == 0 ? a : gcd_division_recursive(b,a % b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 2;i <= n;i++) {
            for (int j = 1; j < i; j++) {
                if (gcd_division_recursive(j, i) == 1) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }
}