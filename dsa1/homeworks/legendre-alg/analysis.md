The given Legendre algorithm is calculating number's power. In algorithm we need to pass argument `a` and `k`. it will calculate `a`'s `k`-th power.

## Best-case

The best-case is \(\Omega(1) \) because if `k`=0 then it will run in constant time therefore best-case time complexity is \(\Omega(1)\).

## Worst-case

In worst-case `k` will be eigther odd or even.

- If `k` is even, in each iteration k halves and a is squared. The complexity is \(O(logk)\)
- If `k` is odd, in each iteration k decrements by 1 `s` is multiplied by `a`. The complexity is \(O(k)\)

## Total time complexity
Best-case time complexity: \(\Omega(1)\)
Worst-case time complexity: \(O(log{k})\) even `k` is odd