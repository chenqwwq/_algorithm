//
// Created by 陈炳鑫 on 2022/4/29.
//


#include "stdc++.h"

using namespace std;

class Node {
public:
    bool val;
    bool isLeaf;
    Node *topLeft;
    Node *topRight;
    Node *bottomLeft;
    Node *bottomRight;

    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf, Node *_topLeft, Node *_topRight, Node *_bottomLeft, Node *_bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

class Solution {
public:
    Node *construct(vector<vector<int>> &grid) {
        function<Node *(int x, int y, int len)> dfs;
        dfs = [&](int x, int y, int len) -> Node * {
            if (!len) return nullptr;
            if (len == 1) return new Node(grid[x][y], true);
            bool eq = true;
            int mode = grid[x][y];
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len; ++j) {
                    if (grid[x + i][y + j] != mode) {
                        eq = false;
                        break;
                    }
                }
            }
            if (eq) return new Node(mode, true);
            else {
                auto node = new Node(-1, false);
                node->topLeft = dfs(x, y, len >> 1);
                node->topRight = dfs(x, y + (len >> 1), len >> 1);
                node->bottomLeft = dfs(x + (len >> 1), y, len >> 1);
                node->bottomRight = dfs(x + (len >> 1), y + (len >> 1), len >> 1);
                return node;
            }
        };
        return dfs(0, 0, (int) grid.size());
    }
};