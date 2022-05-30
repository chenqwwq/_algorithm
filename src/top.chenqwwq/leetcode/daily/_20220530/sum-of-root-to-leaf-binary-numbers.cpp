//
// Created by chenqwwq on 2022/5/30.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int sumRootToLeaf(TreeNode *root) {
        function<int(TreeNode *, int)> dfs;
        dfs = [&](TreeNode *node, int val) { ;
            if (node == nullptr) return val;
            int nv = (val << 1) + node->val;
            return dfs(node->left, nv) + dfs(node->right, nv);
        };
        return dfs(root, 0);
    }
};