# Aggressive Cows

**Platform:** GeeksForGeeks  
**Difficulty:** Medium

## Problem Statement

Given the positions of stalls on a straight line and `k` cows, place the cows in the stalls such that the **minimum distance between any two cows is maximized**.

Return the largest possible minimum distance.

---

## Approach

- Sort the stall positions.
- Use **Binary Search on the answer** (minimum possible distance).
- For each candidate distance:
  - Greedily place the first cow in the first stall.
  - Place each subsequent cow in the earliest stall that is at least the candidate distance away from the last placed cow.
- If all `k` cows can be placed, try a larger distance.
- Otherwise, try a smaller distance.

---

## Algorithm

1. Sort the array of stall positions.
2. Set:
   - `low = 1`
   - `high = lastPosition - firstPosition`
3. While `low <= high`:
   - Compute `mid`.
   - Check if all cows can be placed with at least `mid` distance.
   - If yes:
     - Store `mid` as the current answer.
     - Search in the higher half.
   - Else:
     - Search in the lower half.
4. Return the stored answer.

---

## Time Complexity

- Sorting: **O(n log n)**
- Binary Search: **O(log(maxDistance))**
- Feasibility Check: **O(n)**

Overall:

**O(n log n + n log(maxDistance))**

---

## Space Complexity

**O(1)** (excluding sorting implementation)

---

## Key Concepts

- Binary Search on Answer
- Greedy Placement
- Feasibility Check
- Monotonic Search Space
