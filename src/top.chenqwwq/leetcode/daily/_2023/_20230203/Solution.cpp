//
// Created by chenqwwq on 2023/2/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool btreeGameWinningMove(TreeNode *root, int n, int x) {
        if (!root) return false;
        if (root->val != x) return btreeGameWinningMove(root->left, n, x) || btreeGameWinningMove(root->right, n, x);
        int lc = getCnt(root->left), rc = getCnt(root->right);
        return lc > n >> 1 || rc > n >> 1 || n - lc - rc - 1 > n >> 1;
    }

    int getCnt(TreeNode *root) {
        if (!root) return 0;
        if (!root->left && !root->right) return 1;
        return getCnt(root->left) + getCnt(root->right) + 1;
    }
};