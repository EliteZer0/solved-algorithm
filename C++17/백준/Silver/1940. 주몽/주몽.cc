#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M;
    cin >> N;
    cin >> M;
    int arr[15000];
    
    for(int i = 0; i<N; i++){
        cin >> arr[i];
    }

    sort(arr, arr+N);

    int left = 0;
    int right = N-1;
    int cnt = 0;

    while(left < right){
        int sum = arr[left] + arr[right];

        if(sum == M){
            cnt++;
            left++;
            right--;
        }
        else if(sum < M) left++;
        else right--;
    }
    
    cout << cnt;
    return 0;
}