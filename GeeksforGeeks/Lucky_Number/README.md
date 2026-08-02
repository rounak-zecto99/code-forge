# Lucky Numbers

**Platform:** GeeksForGeeks  
**Difficulty:** Easy

## Problem Statement

Determine whether a given number is a **Lucky Number**.

A number is considered lucky if it survives the elimination process:

1. Start with the natural numbers.
2. Remove every 2nd number.
3. From the remaining numbers, remove every 3rd number.
4. Then remove every 7th number, and so on.
5. If the given number is never removed, it is a Lucky Number.

---

## Approach

- Simulate the elimination process using recursion.
- At each step:
  - If the current elimination counter is greater than the number, the number survives and is lucky.
  - If the number is divisible by the current counter, it gets eliminated.
  - Otherwise, update its position after elimination and continue recursively with the next counter.

---

## Algorithm

1. Start with an elimination counter of `2`.
2. If `counter > n`, return `true`.
3. If `n % counter == 0`, return `false`.
4. Update:
   ```
   n = n - (n / counter)
   ```
5. Recur with `counter + 1`.
6. Return the result.

---

## Time Complexity

**O(√n)** (approximately, since the elimination counter grows until it exceeds the current value of `n`)

---

## Space Complexity

**O(√n)** (recursive call stack)

---

## Key Concepts

- Recursion
- Mathematical Simulation
- Elimination Process
