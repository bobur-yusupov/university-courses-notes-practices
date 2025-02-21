my_list = [6, 1, -8, 2, 5, 9, -100, 67]

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(n - i - 1):
            if (arr[j] > arr[j+1]):
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                
                swapped = True
        
        if not swapped:
            break
        
    return arr
        

print(bubble_sort(my_list))
