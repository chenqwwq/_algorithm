//
// Created by 陈炳鑫 on 2022/4/18.
//


#include <iostream>

using namespace std;

string word;
int ans = 0;

void handle(int l, int r) {
    if (l < 0 || r >= word.length()) return;
    while (l >= 0 && r < word.length() && word[l] == word[r]) {
        l--;
        r++;
    }
    if (r - l - 1 > ans) ans = r - l - 1;
}

int main() {
    getline(cin, word);
    if (word.length() < 2) {
        printf("%d\n", (int) word.length());
        return 0;
    }
    ans = 1;
    int n = (int) word.size();
    for (int i = 1; i < n - 1; ++i) {
        handle(i - 1, i + 1);
        if (word[i] == word[i + 1]) handle(i - 1, i + 2);
    }

    printf("%d\n", ans);
    return 0;
}