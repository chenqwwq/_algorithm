//
// Created by chenqwwq on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    TreeNode *ans;
    bool flag = false;
public:
    TreeNode *inorderSuccessor(TreeNode *root, TreeNode *p) {
        inorder(root, p);
        return ans;
    }

    void inorder(TreeNode *node, TreeNode *p) {
        if (!node) {
            return;
        }
        inorder(node->left, p);
        if (flag) {
            ans = node;
            flag = false;
            return;
        }
        if (p == node) {
            flag = true;
        }
        inorder(node->right, p);
    }
};