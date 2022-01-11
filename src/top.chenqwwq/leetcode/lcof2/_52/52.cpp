//
// Created by 陈炳鑫 on 2022/1/5.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    void inorder(TreeNode *root, vector<int> *vec) {
        if (root == nullptr) {
            return;
        }
        if (root->left != nullptr) {
            inorder(root->left, vec);
        }
        vec->push_back(root->val);
        inorder(root->right, vec);
    }


    TreeNode *increasingBST(TreeNode *root) {
        vector<int> vec;
        inorder(root, &vec);
        auto fake = new TreeNode(-1);
        auto curr = fake;
        for (int value: vec) {
            curr->right = new TreeNode(value);
            curr = curr->right;
        }
        return fake->right;
    }
};