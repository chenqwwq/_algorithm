//
// Created by chenqwwq on 2022/7/2.
//


#include "iostream"
#include "map"
#include "vector"
#include "functional"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, child;
    cin >> n;
    map<int, vector<int>> graph;
    int colors[n];
    for (int i = 1; i < n; i++) {
        cin >> child;
        if (!graph.count(child - 1)) graph[child - 1] = {};
        graph[child - 1].push_back(i);
    }
    for (int &c: colors) cin >> c;
    function<void(int, int)> dfs;
    int ans = 0;
    dfs = [&](int pos, int curColor) {
        if(curColor != colors[pos]) ans++;
        for(int next : graph[pos]){
            dfs(next,colors[pos]);
        }
    };
    dfs(0,0);
    cout << ans << endl;
    return 0;
}