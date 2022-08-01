//
// Created by chenqwwq on 2022/1/12.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    TreeNode *pruneTree(TreeNode *root) {
        return prune(root) ? root : nullptr;
    }

    bool prune(TreeNode *root) {
        if (!root) {
            return false;
        }
        bool t1 = prune(root->left);
        if (!t1) {
            root->left = nullptr;
        }
        bool t2 = prune(root->right);
        if (!t2) {
            root->right = nullptr;
        }
        return root->val == 1 || t1 || t2;
    }
};