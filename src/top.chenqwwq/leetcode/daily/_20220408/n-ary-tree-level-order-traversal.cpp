//
// Created by 陈炳鑫 on 2022/4/8.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrder(Node *root) {
        if(!root) return {};
        vector<vector<int>> ans;
        deque<Node *> dq;
        dq.push_back(root);
        while (!dq.empty()) {
            vector<int> tmp;
            int n = (int) dq.size();
            while (n-- > 0) {
                auto node = dq.front();
                dq.pop_front();
                tmp.push_back(node->val);
                for (auto child: node->children) dq.push_back(child);
            }
            ans.push_back(tmp);
        }
        return ans;
    }
};