from typing import List

def generate_variations(elements: List[int], k: int, current: List[int] = []):
    if len(current) == k:
        print(current)
        return
    
    for i in range(len(elements)):
        next_element = elements[i]
        rest = elements[:i] + elements[i+1:]
        generate_variations(rest, k, current=current+[next_element])


generate_variations([1, 2, 3, 4], 2)

print("\n")
print("\n")

def generate_combinations(elements: List[int], k: int, start = 0, current: List[int] = []):
    if len(current) == k:
        print(current)
        return
    
    for i in range(start, len(elements)):
        generate_combinations(elements, k, i + 1, current=current+[elements[i]])

generate_combinations([1, 2, 3, 4], 2)

def generate_variations_with_repetitions(elements: List[int], k: int, current: List[int] = []):
    if len(current) == k:
        