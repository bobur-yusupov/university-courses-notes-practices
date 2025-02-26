my_list = [6, 1, -8, 2, 5, 9]

def max_part(arr):
    max_sum = arr[0] # 16
    current_sum  = arr[0] # 16
    
    start = 0; # 3
    end = 0; # 5
    temp_start = 0 # 3
    
    for j in range(1, len(arr)):
        if current_sum + arr[j] > arr[j]:
            current_sum += arr[j]
        else:
            current_sum = arr[j]
            temp_start = j
            
        if current_sum > max_sum:
            max_sum = current_sum
            start = temp_start
            end = j
            
    return (start, end)
