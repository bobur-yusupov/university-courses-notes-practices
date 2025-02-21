my_list = [6, 1, -8, 2, 5, 9, -100, 67]

def bubble_sort(arr):
    n = len(arr)
    
    while True:
        swapped = False # to track whether in the interation any element swapped if not whole iteration will stop
        last_swapped_index = 0 # to track the index of the last element
        
        for j in range(1, n):
            if arr[j - 1] > arr[j]:
                arr[j - 1], arr[j] = arr[j], arr[j - 1]
                swapped = True
                last_swapped_index = j

        # If no swaps it will stop iteration
        if not swapped:
            break
        
        n = last_swapped_index # update n to last_swapped_index in every iteration
        
    return arr
        

print(bubble_sort(my_list))
