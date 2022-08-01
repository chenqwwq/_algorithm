//
// Created by chenqwwq on 2022/1/12.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    vector<int> ans;
public:
    vector<int> largestValues(TreeNode *root) {
        dfs( root, 0);
        return ans;
    }

    void dfs( TreeNode *node, int depth) {
        if (node == nullptr) {
            return;
        }
        while (ans.size() <= depth) {
            ans.push_back(INT_MIN);
        }
        ans[depth] = max(node->val, ans[depth]);
        dfs(node->left,depth+1);
        dfs(node->right,depth+1);
    }
};