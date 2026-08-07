# Count Triplets with Sum Smaller than Target

## Problem

Given an integer array `arr[]` and an integer `target`, count the number of triplets `(i, j, k)` such that:

- `i < j < k`
- `arr[i] + arr[j] + arr[k] < target`

Return the total number of such triplets.

---

## Approach

This solution uses **Sorting + Two Pointers**.

### Key Observation

After sorting the array:

- Fix the first element of the triplet.
- Use two pointers to find the remaining two elements.
- If the current sum is smaller than the target, then **every element between the two pointers can form a valid triplet**.

This allows us to count multiple triplets in a single step instead of checking every combination.

---

## Algorithm

1. Sort the array.
2. Iterate through the array and fix the first element.
3. Initialize:
   - `start = i + 1`
   - `end = n - 1`
4. Compute the remaining target:

   ```text
   newTarget = target - arr[i]
   ```

5. While `start < end`:
   - Calculate:

     ```text
     sum = arr[start] + arr[end]
     ```

   - If `sum < newTarget`:
     - Every index from `start + 1` to `end` also forms a valid triplet.
     - Count all of them:

       ```text
       end - start
       ```

     - Move `start` forward.
   - Otherwise:
     - Move `end` backward.

6. Return the total count.

---

## Why `triplets += end - start`?

Suppose the sorted array is:

```text
[1, 2, 3, 5, 7]
```

Assume:

```text
arr[i] = 1
newTarget = 10
```

Current pointers:

```text
start = 1 (2)
end   = 4 (7)
```

Current sum:

```text
2 + 7 = 9 < 10
```

Since the array is sorted:

```text
2 + 5 < 10
2 + 3 < 10
```

All indices between `start` and `end` will also satisfy the condition.

So instead of checking individually, we directly count:

```text
end - start = 4 - 1 = 3
```

Valid triplets:

```text
(1,2,7)
(1,2,5)
(1,2,3)
```

This optimization reduces the complexity from **O(n³)** to **O(n²)**.

---

## Dry Run

**Input**

```text
arr = [5, 1, 3, 4, 7]
target = 12
```

After sorting:

```text
[1, 3, 4, 5, 7]
```

### i = 0 (1)

```text
newTarget = 11

start = 1
end = 4
```

```
3 + 7 = 10 < 11
Count += 3
Move start
```

```
4 + 7 = 11
Move end
```

```
4 + 5 = 9 < 11
Count += 1
```

Current answer = **4**

### i = 1 (3)

```
newTarget = 9
```

```
4 + 7 = 11
Move end
```

```
4 + 5 = 9
Move end
```

No more valid triplets.

**Output**

```text
4
```

---

## Time Complexity

- Sorting: **O(n log n)**
- Two-pointer traversal for every element: **O(n²)**

**Overall:** `O(n²)`

---

## Space Complexity

Only a few variables are used.

**Space:** `O(1)`

---

## Java Solution

```java
class Solution {
    int countTriplets(int target, int arr[]) {
        Arrays.sort(arr);
        int triplets = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            int start = i + 1;
            int end = arr.length - 1;
            int newt = target - arr[i];

            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum < newt) {
                    triplets += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }

        return triplets;
    }
}
```

---

## Key Idea

For every fixed first element:

- Use two pointers to search for the remaining two elements.
- Whenever the current pair satisfies the condition, **all elements between `start` and `end` are also valid** because the array is sorted.
- Count them together using:

```text
triplets += end - start
```

This makes the solution run efficiently in **O(n²)** time.
