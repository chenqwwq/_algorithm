//
// Created by 陈炳鑫 on 2022/5/6.
//


#include <iostream>

using namespace std;

const int maxn = 2 * 1e5 + 1;

char mapping[26];

#define init() for(int i = 0;i < 26;i++) mapping[i] = (char)(i + 'a');

int main() {
    int n;
    cin >> n;
    while (n--) {
        init();
        int m, k, curr = 0;
        cin >> m >> k;
        string in;
        cin >> in;
        for (int i = 0; i < m; ++i) {
            int pos = in[i] - 'a';
            if (mapping[pos] != 'a' && k > 0) {
                mapping[pos] = k >= (pos - curr) ? 'a' : char('a' + (pos - k));
                for (int j = pos - 1; j >= 0 && mapping[pos] < mapping[j]; --j) {
                    mapping[j] = mapping[pos];
                }
                k -= (pos - curr);
                curr = pos;
            }
            printf("%c", mapping[pos]);
        }
        cout << endl;
    }
    return 0;
}