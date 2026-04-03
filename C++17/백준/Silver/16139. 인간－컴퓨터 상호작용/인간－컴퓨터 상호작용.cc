#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    cin >> str;

    int len = str.length();
    vector<vector<int>> cnt(len + 1, vector<int>(26, 0));
    char c = str[0];

    for (int i = 1; i <= len; i++) {
        for (int j = 0; j < 26; j++) {
            cnt[i][j] = cnt[i - 1][j];
        }
        cnt[i][str[i - 1] - 'a']++;
    }
    
    int q;
    cin >> q;

    for(int i = 0; i<q; i++){
        char cmd;
        int start, end;
        cin >> cmd >> start >> end;

        cout << cnt[end + 1][cmd - 'a'] - cnt[start][cmd - 'a'] << "\n";
    }
    return 0;
}