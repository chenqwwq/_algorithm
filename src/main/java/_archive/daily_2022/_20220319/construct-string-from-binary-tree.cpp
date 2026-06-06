//
// Created by 陈炳鑫 on 2022/3/19.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string tree2str(TreeNode *root) {
        if (!root) return "";
        string ans = to_string(root->val);
        if (!root->left && !root->right) return ans;
        ans += "(" + tree2str(root->left) + ")";
        if(!root->right) return ans;
        return ans + "(" + tree2str(root->right) + ")";
    }
};