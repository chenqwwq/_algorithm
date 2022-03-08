//
// Created by 陈炳鑫 on 2022/3/6.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    TreeNode *createBinaryTree(vector<vector<int>> &descriptions) {
        unordered_map<int, TreeNode *> mmap;
        unordered_set<int> parent, child;
        for (auto des: descriptions) {
            parent.insert(des[0]);
            child.insert(des[1]);
            if (mmap.find(des[0]) == mmap.end()) mmap[des[0]] = new TreeNode(des[0]);
            if (mmap.find(des[1]) == mmap.end()) mmap[des[1]] = new TreeNode(des[1]);
            if (des[2]) mmap[des[0]]->left = mmap[des[1]]; else mmap[des[0]]->right = mmap[des[1]];
        }
        for (int c :child) if(parent.find(c) != parent.end()) parent.erase(c);
        return mmap[parent.begin().operator*()];
    }
};

int main() {
    vector<vector<int>> p1{{20, 15, 1},
                           {20, 17, 0},
                           {50, 20, 1},
                           {50, 80, 0},
                           {80, 19, 1}};

    (new Solution)->createBinaryTree(p1);
}