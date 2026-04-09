#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, t;

    cin >> n >> t;
    
    queue<int> apt;

    for(int i = 0; i < n*2; i++){
        int player;
        cin >> player;
        apt.push(player);
    }
    
    while(t--) {
        int stop;
        cin >> stop;

        while(stop-- > 1){
            apt.push(apt.front());
            apt.pop();
        }

        int loser = apt.front();

        cout << loser << ' ';
    }
    
    return 0;
}