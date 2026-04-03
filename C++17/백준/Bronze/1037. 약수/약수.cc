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

	if (n % 2 == 0)
	{
		int a = factors[n / 2];
		int b = factors[n / 2 - 1];

		cout << a * b;
	}
	else
	{
		int a = factors[n / 2];

		cout << a * a;
	}
	return 0;
}