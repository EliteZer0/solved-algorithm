#include <bits/stdc++.h>
using namespace std;

int n, d;

struct shortcut {
    int s, e, dist;
};

shortcut shortcut_list[12];
int dis[10001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> d;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int s, e, dist;
        cin >> s >> e >> dist;

        bool found = false;
        for (int j = 0; j < cnt; j++){
            if(shortcut_list[j].s == s && shortcut_list[j].e == e){
                shortcut_list[j].dist = min(shortcut_list[j].dist, dist);
                found = true;
                break;
            }
        }

        if(found) continue;
        if(e > d) continue;
        if(dist >= e-s) continue;
        
        shortcut_list[cnt] = {s, e, dist};
        cnt ++;
    }

    sort(shortcut_list, shortcut_list+cnt, [](shortcut a, shortcut b){
       return a.s < b.s;
    });

    dis[0] = 0;
    for (int i = 1; i <= d; i++) {
        dis[i] = i;
    }
    
    for (int i = 0; i < d; i++) {
        dis[i + 1] = min(dis[i + 1], dis[i] + 1);
        
        for (int j = 0; j < cnt; j++) {
            if (shortcut_list[j].s == i) {
                int end = shortcut_list[j].e;
                int distance = shortcut_list[j].dist;
                dis[end] = min(dis[end], dis[i] + distance);
            }
        }
    }

    cout << dis[d];
    return 0;
}