def permutations(elements: list, current = []) -> None:
    if not elements:
        print(current)
        return
    
    for i in range(len(elements)):
        next_element: int = elements[i]
        rest: list = elements[:i] + elements[i+1:]
        permutations(rest, current + [next_element])

permutations([1, 2, 3, 4, 5])