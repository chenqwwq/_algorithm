//
// Created by chenqwwq on 2022/1/6.
//

#include "stdc++.h"
#include "common.h"

using namespace std;


class Solution {
public:
    bool findTarget(TreeNode *root, int k) {
        if (root == nullptr) {
            return false;
        }
        set<int> values;

        traversal(root, &values);
        for (int value : values){
            if(value != k - value && values.find(k - value) != values.end()){
                return true;
            }
        }
        return false;
    }

    void traversal(TreeNode *root, set<int> *target) {
        if (root == nullptr) {
            return;
        }
        target->insert(root->val);
        traversal(root->right, target);
        traversal(root->left, target);
    }
};