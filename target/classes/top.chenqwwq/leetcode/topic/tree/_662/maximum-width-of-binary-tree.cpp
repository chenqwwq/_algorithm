//
// Created by 陈炳鑫 on 2022/3/24.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int widthOfBinaryTree(TreeNode *root) {
        if (!root) return 0;
        deque<pair<TreeNode *, long long>> q;
        q.emplace_back(root, 0);
        int ans = INT_MIN;
        while (!q.empty()) {
            long long first = q.front().second;
            ans = max(ans, (int) (q.back().second - q.front().second + 1));
            for (int i = 0, n = q.size(); i < n; ++i) {
                auto[node, pos] = q.front();
                pos -= first;
                q.pop_front();
                if (node->left) q.emplace_back(node->left, 2 * pos);
                if (node->right) q.emplace_back(node->right, 2 * pos + 1);
            }
        }
        return ans;
    }
};
