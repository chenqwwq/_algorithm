//
// Created by chenqwwq on 2025/5/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

// 树形 DP 板子
class Solution {
public:
    int rob(TreeNode *root) {
        auto [a, b] = h(root);
        return max(a, b);
    }

    // 第一个表示偷当前节点的价值
    // 第二个表示不偷当前节点的最大价值
    pair<int, int> h(TreeNode *node) {
        if (!node) return {0, 0};
        auto [l1, l2] = h(node->left);
        auto [r1, r2] = h(node->right);
        // 偷当前节点的总价值
        int v1 = node->val + l2 + r2;
        // 不偷当前节点的总价值
        int v2 = max(l1, l2) + max(r1, r2);
        return {v1, v2};
    }
};