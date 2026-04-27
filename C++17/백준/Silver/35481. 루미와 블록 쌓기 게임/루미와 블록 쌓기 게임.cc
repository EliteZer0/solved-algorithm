#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string pattern[19] = {
    ".#########",
    "#.########",
    "##.#######",
    "###.######",
    "####.#####",
    "#####.####",
    "######.###",
    "#######.##",
    "########.#",
    "#########.",
    "########.#",
    "#######.##",
    "######.###",
    "#####.####",
    "####.#####",
    "###.######",
    "##.#######",
    "#.########",
    ".#########"
    };

    string board[20];
    for(int i = 0; i<20; i++)
        cin >> board[i];

    int cnt = 0;
    for (int i = 19; i > 0; i--) {
        if (board[i] == pattern[i-1]) {
            cnt++;
        } else {
            break;
        }
    }

    string ans = "X";
    if(cnt == 0){
        cout << ans;
        return 0;
    }
    else if (cnt == 1){
        if(board[18][0] == '#')
            ans = "9";
    }
    else if(cnt == 19){
        if(board[0][0] == '#')
            ans = "GM";
        else
            ans = "S9";
    }
    else if(cnt < 10){
        if(board[19-cnt][cnt-1] == '#'){
            ans = to_string(10-cnt);
        }
        else{
            ans = to_string(11-cnt);
        }
    }
    else{
        if(board[19-cnt][9 - (cnt - 10)] == '#'){
            ans = "S" + to_string(cnt - 9);
        }
        else{
            ans = "S" + to_string(cnt - 10);
        }
    }

    if(ans == "S0")
        ans = "1";
    
    cout << ans;
    return 0;
}