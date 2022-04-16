//
// Created by chenqwwq on 2022/1/11.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class CBTInserter {
public:
    vector<TreeNode*> tree;

    CBTInserter(TreeNode *root) {
        dfs(root);
    }

    void dfs(TreeNode *node) {
        deque<TreeNode *> d;
        d.push_back(node);
        while (!d.empty()) {
            TreeNode *tn = d.front();
            d.pop_front();
            tree.push_back(tn);
            if (tn->left != nullptr) {
                d.push_back(tn->left);
            }
            if (tn->right != nullptr) {
                d.push_back(tn->right);
            }
        }
    }

    int insert(int v) {
        auto pNode = new TreeNode(v);
        tree.push_back(pNode);
        int n = tree.size();
        int parent = ((n) >> 1) - 1;
        if (parent >= 0) {
            if ((n & 1) == 1) {
                tree[parent]->right = tree[n - 1];
            } else {
                tree[parent]->left = tree[n - 1];
            }
            return tree[parent]->val;
        }
        return -1;
    }

    TreeNode *get_root() {
        return tree[0];
    }
};