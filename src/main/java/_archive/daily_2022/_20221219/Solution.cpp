//
// Created by chenqwwq on 2022/12/19.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
// 并查集版本
// ranks 表示每个点的秩,它表示以该节点为根的树的高度的上界
    vector<int> nums, ranks;

    void init(int n) {
        ranks.resize(n);
        nums.resize(n);
        for (int i = 0; i < n; i++) {
            nums[i] = i;
            ranks[i] = 0;
        }
    }

// 路径压缩
    int find(int n) {
        if (n >= nums.size()) return -1;
        if (nums[n] == n) return n;
        nums[n] = find(nums[n]);
        return nums[n];
    }

// 按秩合并
    void _union(int a, int b) {
        int n1 = find(a), n2 = find(b);
        if (ranks[n1] < ranks[n2]) nums[n1] = n2;
        else {
            nums[n2] = n1;
            if (ranks[n1] == ranks[n2]) ranks[n1]++;
        }
    }


    bool validPath(int n, vector<vector<int>> &edges, int source, int destination) {
        init(n);
        for(auto edge : edges) _union(edge[0],edge[1]);
        return find(source) == find(destination);
    }


// BFS 版本
//    bool validPath(int n, vector<vector<int>> &edges, int source, int destination) {
//        map<int, set<int>> mmap;
//        for (int i = 0; i < n; i++) mmap[i] = {};
//        for (auto edge: edges) {
//            mmap[edge[0]].insert(edge[1]);
//            mmap[edge[1]].insert(edge[0]);
//        }
//
//        bool exist[n];
//        ::memset(exist, false, sizeof exist);
//        deque<int> q;
//        q.push_back(source);
//        exist[source] = true;
//        while (!q.empty()){
//            auto cur = q.front();q.pop_front();
//            if(cur == destination) return true;
//            for(auto next : mmap[cur]){
//                if(exist[next]) continue;
//                exist[next] = true;
//                q.push_back(next);
//            }
//        }
//        return false;
//    }
};