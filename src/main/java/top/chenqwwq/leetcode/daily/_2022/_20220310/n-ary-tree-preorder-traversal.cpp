//
// Created by 陈炳鑫 on 2022/3/10.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> preorder(Node *root) {
        if (!root) return {};
        vector<int> ans;
        ans.emplace_back(root->val);
        for (auto child: root->children) {
            vector<int> nums = preorder(child);
            ans.insert(ans.end(),nums.begin(),nums.end());
        }
        return ans;
    }
};