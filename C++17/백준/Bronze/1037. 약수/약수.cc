#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	int factors[1000000];

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> factors[i];
	}

	sort(factors, factors + n);

	cout << factors[0] * factors[n - 1];

	return 0;
}