my_list = [6, 1, -8, 2, 5, 9, -100, 67]

def insertion_sort(arr):
    n = len(arr)
    ind = 0
    
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        
        while arr[j] > key and j >= 0:
            arr[j + 1] = arr[j]
            j -= 1
            
        arr[j + 1] = key
        
    return arr
    
print(insertion_sort(my_list))
