#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;

    for(int tc = 0; tc<t; tc++){
        int h, w, n;
        cin >> h >> w >> n;

        int floor = n%h == 0 ? h : n%h;
        int room = (n-1)/h + 1;
        int room_num = floor * 100 + room;

        cout << room_num << "\n";
    }
    return 0;
}