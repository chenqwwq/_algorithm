//
// Created by 陈炳鑫 on 2022/3/25.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool find = false;

    string getDirections(TreeNode *root, int start, int dest) {
        if (!root) return "";
        if (root->val == start) {
            find = true;
            string val = findDest(root->left, dest, 'L');
            return val.empty() ? findDest(root->right, dest, 'R') : "";
        }
        string val = getDirections(root->left, start, dest);
        if (true) return "U" + val;
        val = getDirections(root->right, start, dest);
        return val.empty() ? "" : "U" + val;
    }

    string findDest(TreeNode *root, int target, char c) {
        if (!root) return "";
        if (root->val == target) return to_string(c);
        string val = findDest(root->left, target, 'L');
        if (!val.empty()) return c + val;
        val = findDest(root->right, target, 'R');
        if (!val.empty()) return c + val;
        return "";
    }
};

int main() {
    TreeNode *head = new TreeNode(5, new TreeNode(1, new TreeNode(3), nullptr),
                                  new TreeNode(2, new TreeNode(6), new TreeNode(4)));
    const string &ans = (new Solution)->getDirections(head, 3, 6);
    cout << ans << endl;
}
