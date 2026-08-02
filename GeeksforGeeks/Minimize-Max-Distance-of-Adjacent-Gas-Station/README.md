# Minimize Max Distance to Gas Station

**Platform:** GeeksForGeeks  
**Difficulty:** Hard

## Problem Statement

Given the positions of existing gas stations and `k` additional gas stations that can be placed, minimize the maximum distance between any two adjacent gas stations.

Return the smallest possible value of this maximum distance.

---

## Approach

- The answer is a real number, so apply **Binary Search on the Answer**.
- The search space is:
  - `low = 0`
  - `high = maximum gap between consecutive stations`
- For each candidate maximum distance `mid`:
  - Calculate how many additional stations are required so that no gap exceeds `mid`.
  - For a gap of length `L`, the required stations are:
    ```
    ceil(L / mid) - 1
    ```
- If more than `k` stations are needed, `mid` is too small, so increase the search range.
- Otherwise, try a smaller maximum distance.

---

## Why `ceil(gap / mid) - 1`?

For a gap of length `L` and an allowed maximum distance `D`:

- The gap must be divided into segments of length at most `D`.
- Number of required segments:
  ```
  ceil(L / D)
  ```
- Since existing stations already create one segment, the number of new stations needed is:

```
ceil(L / D) - 1
```

Example:

| Gap | Max Distance | Stations Needed |
|-----:|-------------:|----------------:|
| 10 | 3 | 3 |
| 10 | 5 | 1 |
| 10 | 10 | 0 |

---

## Algorithm

1. Find the maximum gap between consecutive stations.
2. Binary search on the answer.
3. For each candidate distance:
   - Compute the total additional stations required.
4. If required stations > `k`:
   - Increase the candidate distance.
5. Otherwise:
   - Try a smaller distance.
6. Continue until the desired precision (`1e-6`) is reached.

---

## Time Complexity

- Finding maximum gap: **O(n)**
- Binary Search: **O(log((maxGap) / ε))**
- Feasibility Check per iteration: **O(n)**

Overall:

**O(n × log((maxGap) / ε))**

where `ε = 1e-6`.

---

## Space Complexity

**O(1)**

---

## Key Concepts

- Binary Search on Answer
- Floating Point Binary Search
- Greedy Feasibility Check
- Mathematical Observation
- Precision-Based Search
