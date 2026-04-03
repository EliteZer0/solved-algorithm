#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int R, C, Q;
    cin >> R >> C >> Q;
    long photo[1001][1001];
    for(int i = 1; i<=R; i++){
        for(int j = 1; j<=C; j++){
            int x;
            cin >> x;
            photo[i][j] = photo[i-1][j] + photo[i][j-1] - photo[i-1][j-1] + x;
        }
    }

    while(Q--){
        int r1, c1, r2, c2;
        cin >> r1 >> c1 >> r2 >> c2;
    
        long ans = (photo[r2][c2] - photo[r1-1][c2] - photo[r2][c1-1] + photo[r1-1][c1-1])/((r2-r1+1)*(c2-c1+1));
        
        cout << ans << "\n";
    }
    return 0;
}