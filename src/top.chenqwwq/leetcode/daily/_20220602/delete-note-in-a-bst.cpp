//
// Created by chenqwwq on 2022/6/2.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    TreeNode *deleteNode(TreeNode *root, int key) {
        if (!root) return nullptr;
        if (root->val > key) {
            root->left = deleteNode(root->left, key);
        } else if (root->val < key) {
            root->right = deleteNode(root->right, key);
        } else {
            if (!root->right && !root->left) return nullptr;
            if (!root->right) return root->left;
            if (!root->left) return root->right;
            // 找到右子树的最小点
            auto node = root->right;
            while (node->left) node = node->left;
            node->right = deleteNode(root->right, node->val);
            node->left = root->left;
            return node;
        }
        return root;
    }
};