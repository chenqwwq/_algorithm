//
// Created by chenqwwq on 2023/4/18.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int inf = -1;
    int ans = 0;

    int maxAncestorDiff(TreeNode *root) {
        dfs(root);
        return ans;
    }

    pair<int, int> dfs(TreeNode *root) {
        if (!root) return {-1,-1};
        if (!root->left && !root->right) return {root->val, root->val};
        int a = root->val, b = root->val;
        auto pl = dfs(root->left);
        if (pl.first != -1){
            a = min(a, pl.first);
            b = max(b, pl.second);
        }
        auto rl = dfs(root->right);
        if (rl.first != -1){
            a = min(a, min(rl.first, rl.second));
            b = max(b, max(rl.first, rl.second));
        }
        ans = max(ans,max(abs(root->val - a),abs(root->val - b)));
        return {a, b};
    }
};