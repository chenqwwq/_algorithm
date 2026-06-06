package top.chenqwwq.leetcode.daily._2024._20240729;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/7/29
 **/
public class Solution {
    public int calPoints(String[] operations) {
        final List<Integer> nums = new ArrayList<>();
        for(String op : operations){
            switch (op){
                case "+":
                    nums.add(nums.get(nums.size()-1) + nums.get(nums.size()-2));
                    break;
                case "D":
                    nums.add(nums.get(nums.size()-1)*2);
                    break;
                case "C":
                    nums.remove(nums.size()-1);
                    break;
                default:
                    nums.add(Integer.valueOf(op));
            }
        }
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}