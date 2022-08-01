//
// Created by chenqwwq on 2022/1/12.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    vector<int> ans;
    int INF = 0x3F3F3F3F;
public:
    vector<int> rightSideView(TreeNode *root) {
        dfs(root,0);
        return ans;
    }

    void dfs(TreeNode *node, int depth) {
        if (!node) {
            return;
        }
        while (ans.size() <= depth) {
            ans.push_back(INF);
        }
        ans[depth] = node->val;
        dfs(node->left, depth + 1);
        dfs(node->right, depth + 1);
    }
};