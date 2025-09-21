//
// Created by 陈炳鑫 on 2022/3/12.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> postorder(Node *root) {
        if (!root) return {};
        vector<int> ans;
        for (auto child: root->children) {
            auto t = postorder(child);
            ans.insert(ans.end(), t.begin(), t.end());
        }
        ans.push_back(root->val);
        return ans;
    }
};