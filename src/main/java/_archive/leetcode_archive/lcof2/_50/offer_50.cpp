//
// Created by chenqwwq on 2022/1/13.
//

#include "common.h"

using namespace std;

class Solution {
public:
    int pathSum(TreeNode *root, int targetSum) {
        return dfs(root, targetSum, false);
    }

    int dfs(TreeNode *root, int targetSum, bool start) {
        if (!root) {
            return 0;
        }
        int sum = targetSum - root->val;

        return (sum == 0 ? 1 : 0) +
               dfs(root->left, sum, true) +
               dfs(root->right, sum, true) +
               (start ? 0 : (dfs(root->left, targetSum, false) +
                             dfs(root->right, targetSum, false)));
    }
};