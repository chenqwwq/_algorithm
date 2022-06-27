//
// Created by 陈炳鑫 on 2022/3/16.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int rob(TreeNode *root) {
        std::function<vector<int>(TreeNode *root)> dfs;
        dfs = [&](TreeNode *root) -> vector<int> {
            if (!root) return {0, 0};
            if (!root->left && !root->right) return {root->val, 0};
            vector<int> left = dfs(root->left), right = dfs(root->right);
            return {root->val + left[1] + right[1], max(left[0], left[1]) + max(right[0], right[1])};
        };
        auto ans = dfs(root);
        return max(ans[0], ans[1]);
    }
};