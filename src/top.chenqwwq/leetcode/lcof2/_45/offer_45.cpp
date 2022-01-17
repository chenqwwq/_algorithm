//
// Created by chenqwwq on 2022/1/12.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    pair<int, int> ans{-1,-1};

    int findBottomLeftValue(TreeNode *root) {
        dfs(root, 0);
        return ans.second;
    }

    void dfs(TreeNode *root, int depth) {
        if (!root) {
            return;
        }
        if (depth > ans.first) {
            ans = {depth, root->val};
        }
        dfs(root->left, depth + 1);
        dfs(root->right, depth + 1);
    }
};