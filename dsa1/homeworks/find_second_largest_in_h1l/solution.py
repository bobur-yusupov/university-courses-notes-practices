class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def find_second_largest_in_h1l(head: Node):
    if head is None or head.next is None:
        return None
    
    first = head
    second = None
    current = head
    
    while current:
        if current.data > first.data:
            second = first
            first = current
        
        elif second and current.data > second.data and current.data != first.data:
            second = current

        current = current.next


    return second

head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
head.next.next.next.next = Node(5)
head.next.next.next.next.next = Node(6)
head.next.next.next.next.next.next = Node(7)
head.next.next.next.next.next.next.next = Node(8)
head.next.next.next.next.next.next.next.next = Node(9)
head.next.next.next.next.next.next.next.next.next = Node(10)
print(find_second_largest_in_h1l(head).data) # 9