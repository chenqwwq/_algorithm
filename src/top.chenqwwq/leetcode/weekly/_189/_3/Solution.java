package top.chenqwwq.leetcode.weekly._189._3;

import java.util.*;

/**
 * 5414. 收藏清单 显示英文描述
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 * <p>
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 * <p>
 * 提示：
 * <p>
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 *
 * @author chen
 * @date 2020/5/17 上午11:38
 */
public class Solution {
    /**
     * 超时
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        if (favoriteCompanies == null || favoriteCompanies.size() == 0) {
            return res;
        }

        Map<Integer, Set<String>> hash = new HashMap<>();

//         按照升序排列
//        favoriteCompanies.sort(Comparator.comparingInt(List::size));


        // key -> string,value -> count
        outer:
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (favoriteCompanies.get(j).containsAll(favoriteCompanies.get(i))) {
                    continue outer;
                }
            }
            res.add(i);
        }

        return res;
    }
}