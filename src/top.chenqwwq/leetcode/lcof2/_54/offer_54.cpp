//
// Created by chenqwwq on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
    int curr = 0;
public:
    TreeNode *convertBST(TreeNode *root) {
        if (!root) return root;
        convertBST(root->right);
        curr += root->val;
        root->val = curr;
        convertBST(root->left);
        return root;
    }
};