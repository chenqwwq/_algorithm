//
// Created by chenqwwq on 2022/6/21.
//


#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, num;
    int cnt[10];
    cin >> t;
    while (t--) {
        for(int& c : cnt) c = 0;
        cin >> n;
        bool ok = false;
        for (int i = 0; i < n; i++) {
            cin >> num;
            cnt[num % 10]++;
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                for (int k = 0; k < 10; ++k) {
                    if ((i + j + k) % 10 != 3) continue;
                    cnt[i]--;cnt[j]--;cnt[k]--;
                    if(cnt[i] >= 0 && cnt[j] >= 0 && cnt[k] >= 0){
                        ok = true;
                        break;
                    }
                    cnt[i]++;cnt[j]++;cnt[k]++;
                }
            }
        }
        cout << (ok ? "YES" : "NO") << endl;
    }
    return 0;
}