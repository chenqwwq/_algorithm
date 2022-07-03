//
// Created by chenqwwq on 2022/7/2.
//

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n,num;
    cin >> n;
    for(int i = 0;i < n;i++){
        cin >> num;
        if(num) {
            cout << "YES" << endl;
            return 0;
        }
    }
    cout << "NO" << endl;
    return 0;
}