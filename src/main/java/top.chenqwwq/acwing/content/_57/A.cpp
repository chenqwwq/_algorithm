//
// Created by chenqwwq on 2022/6/26.
//


#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n,num;
    cin >> n;
    int s1 = 0,s2 = 0;
    for(int i = 0;i < n;i++){
        cin >> num;
        s1 += num;
    }
    for(int i = 0;i < n;i++){
        cin >> num;
        s2 += num;
    }
    cout << (s1 >= s2 ? "Yes" : "No") << endl;
    return 0;
}