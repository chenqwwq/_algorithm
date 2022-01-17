//
// Created by 陈炳鑫 on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class BSTIterator {
private:
    TreeNode *raw;
    vector<int> values;
    int pos = 0;
public:
    BSTIterator(TreeNode *root) {
        init(root);
    }

    void init(TreeNode *node) {
        if (!node) {
            return;
        }
        init(node->left);
        values.push_back(node->val);
        init(node->right);
    }

    int next() {
        return values[pos++];
    }

    bool hasNext() {
        return pos < values.size();
    }
};

int main(){
    BSTIterator *pIterator = new BSTIterator(new TreeNode(1));
    cout << pIterator->hasNext() << endl;
}