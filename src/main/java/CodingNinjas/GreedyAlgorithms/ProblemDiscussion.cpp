#include <bits/stdc++.h>
using namespace std;

int findMax(int *arr, int n)
{
  int max = arr[0];
  for (int i = 1; i < n; i++)
  {
    if (arr[i] > max)
    {
      max = arr[i];
    }
  }
  return max;
}

int findMin(int *arr, int n)
{
  int min = arr[0];
  for (int i = 1; i < n; i++)
  {
    if (arr[i] < min)
    {
      min = arr[i];
    }
  }
  return min;
}

int solve(int *arr, int k, int n)
{
  int max = findMax(arr, n);
  max /= 2;
  for (int i = 0; i < n; i++)
  {
    if (arr[i] < max)
    {
      arr[i] += k;
    }
    else
    {
      arr[i] -= k;
    }
  }
  max = findMax(arr, n);
  int min = findMin(arr, n);
  return max - min;
}

int main()
{
  // Write your code here
  int n, k;
  cin >> n >> k;
  int arr[n];
  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
  }
  cout << solve(arr, k, n) << endl;
  return 0;
}
