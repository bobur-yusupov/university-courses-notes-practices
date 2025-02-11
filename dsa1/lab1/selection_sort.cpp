/*

Selection sort - algorithm to sort an array based on given condition

1. Finds the minimum number from the array
2. Swap it with the first element
3. Continue with the elements at the rest of the array (go to step 1)

The worst case is to find the minimum it takes n steps, then n - 1... so it gives us: n + (n-1) + (n-2)+...+1 = (n*(n-1)) / 2 ~ n^2
It does not require extra-space, runs on constant space

Time complexity: O(n)
Space complexity: O(1)

*/

#include <bits/stdc++.h>

using namespace std;

void selection_sort(vector<int>& array) {
    int length = array.size();

    for (int i = 0; i < length - 1; i++)
    {
        int min_index = i;

        for (int j = i + 1; j < length; j++) 
        {
            if (array[min_index] > array[j])
            {
                min_index = j;
            }
        }

        swap(array[i], array[min_index]);
    }
}

int main() {
    vector<int> arr = {1, 6, 2, 9, 10, 1};
    vector<int> arr1 = {1, 6, 12, 2, 9, 10};

    selection_sort(arr);

    for (int num: arr)
    {
        cout << num << " ";
    }

    cout << endl;

    // bubble_sort1(arr1);

    // for (int num: arr1)
    // {
    //     cout << num << " ";
    // }

    // cout << endl;

    return 0;
}