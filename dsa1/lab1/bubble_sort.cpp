/*

Bubble sort is a sorting algorithm with O(n^2) time complexity.

The process of the algorithm is it gets the first element, compares with the next, 
if chosen element is bigger than next then these elements swap their places, else it starts the same process from the first element again.

1. select the first element as variable a
2. compare it with the next element (next element b)
 - if a > b -> swap(a, b), continue on the process 
 - else stop the process and select a again (go to step 1)


The worst case time complexity: n + (n-1) + (n-2)...1 = (n(n-1))/2 ~ n^2
As it only requires to swap the elements we do not need extra space, so that it runs on constant space

Time complexity: O(n^2)
Space complexity: O(1)

*/

#include <bits/stdc++.h>

using namespace std;

void bubble_sort(vector<int>& array) {
    int length = array.size();
    bool swapped;

    for (int i = 0; i < length - 1; i++) 
    {
        swapped = false;

        for (int j = 0; j < length - i - 1; j++) 
        {
            if (array[j] > array[j + 1]) {
                swap(array[j], array[j + 1]);
                swapped = true;
            }
        }

        if (!swapped) break;
    }
}

void bubble_sort1(vector<int>& array) {
    int length = array.size();
    bool swapped;

    for (int i = length - 1; i > 0; i--) {
        swapped = false;

        for (int j = length - 1; j > 0; j--) {
            if (array[j] < array[j - 1]) {
                swap(array[j], array[j - 1]);

                swapped = true;
            }
        }

        if (!swapped) break;
    }
}

int main() {
    vector<int> arr = {1, 6, 2, 9, 10};
    vector<int> arr1 = {1, 6, 12, 2, 9, 10};

    bubble_sort(arr);

    for (int num: arr)
    {
        cout << num << " ";
    }

    cout << endl;

    bubble_sort1(arr1);

    for (int num: arr1)
    {
        cout << num << " ";
    }

    cout << endl;
}