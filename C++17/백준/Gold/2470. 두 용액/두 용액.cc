#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, solution[100000];
    cin >> N;
    for(int i = 0; i<N; i++){
        cin >> solution[i];
    }
    sort(solution, solution+N);
    int left = 0;
    int right = N-1;
    int sum;
    int ans = 2000000001;
    int ansList[2];
    while(left<right){
        sum = solution[left] + solution[right];
       
        if(ans>abs(sum)){
            ans = abs(sum);
            ansList[0] = solution[left];
            ansList[1] = solution[right];
        }
        
        if(sum<0) left++;
        else if(sum>0) right --;
        else {
            cout << solution[left] << " " << solution[right];
            return 0;
        }
    }

    cout << ansList[0] << " " << ansList[1];
    return 0;
}