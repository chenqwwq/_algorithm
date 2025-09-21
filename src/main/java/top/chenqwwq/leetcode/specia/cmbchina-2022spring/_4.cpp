//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string deleteText(string article, int index) {
        if (article[index] == ' ') return article;
        int n = (int) article.size();
        int i = index;
        while (i >= 0 && article[i] != ' ') {
            article[i--] = '#';
        }
        int j = index;
        while (j < n && article[j] != ' ') {
            article[j++] = '#';
        }
        string ans =  (i >= 0 ? article.substr(0, i) : "") + article.substr(j, n);
        if(ans.empty()) return ans;
        ans.erase(0,ans.find_first_not_of(" "));
        ans.erase(ans.find_last_not_of(" ")+1);
        return ans;
    }
};

int main() {
    cout << (new Solution)->deleteText("Hello World", 2) << endl;
}
