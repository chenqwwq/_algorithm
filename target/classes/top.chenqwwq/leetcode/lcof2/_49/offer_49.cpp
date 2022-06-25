//
// Created by chenqwwq on 2022/1/13.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    int ans = 0;
public:
    int sumNumbers(TreeNode *root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode *node, int val) {
        if (!node) {
            return;
        }
        val = val * 10 + node->val;
        if (!node->left && !node->right) {
            ans += val;
            return;
        }
        dfs(node->left, val);
        dfs(node->right, val);
    }
};