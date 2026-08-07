# Longest Substring with Exactly K Unique Characters

## Problem
Given a string `s` and an integer `k`, find the length of the **longest substring containing exactly `k` distinct characters**.

If no such substring exists, return `-1`.

---

## Approach

This solution uses the **Sliding Window** technique along with a **HashMap**.

- The HashMap stores the frequency of each character in the current window.
- Expand the window by moving the right pointer.
- If the number of distinct characters becomes greater than `k`, shrink the window from the left until it becomes valid.
- Whenever the window contains exactly `k` distinct characters, update the maximum length.

---

## Algorithm

1. Create a `HashMap<Character, Integer>` to store character frequencies.
2. Initialize:
   - `back = 0` → Left boundary of the window.
   - `size = -1` → Stores the maximum valid length.
3. Traverse the string using the right pointer.
4. Add the current character to the map.
5. While the map contains more than `k` distinct characters:
   - Remove characters from the left.
   - Decrease their frequency.
   - Remove them from the map when their frequency becomes `0`.
6. If the map contains exactly `k` distinct characters:
   - Update the answer.
7. Return the maximum length.

---

## Dry Run

**Input**

```text
s = "aabacbebebe"
k = 3
```

| Right | Character | Window | Distinct | Max Length |
|------:|-----------|--------|---------:|-----------:|
| 0 | a | a | 1 | - |
| 1 | a | aa | 1 | - |
| 2 | b | aab | 2 | - |
| 3 | a | aaba | 2 | - |
| 4 | c | aabac | 3 | 5 |
| 5 | b | aabacb | 3 | 6 |
| 6 | e | Too many → shrink | 3 | 6 |
| 7 | b | cbeb | 3 | 6 |
| 8 | e | cbebe | 3 | 6 |
| 9 | b | cbebeb | 3 | 6 |
| 10 | e | cbebebe | 3 | **7** |

**Output**

```text
7
```

Longest substring: `"cbebebe"`

---

## Time Complexity

- Each character is inserted into the HashMap at most once.
- Each character is removed from the HashMap at most once.

**Time:** `O(n)`

---

## Space Complexity

The HashMap stores at most `k` distinct characters (or the character set size).

**Space:** `O(k)` (or `O(Σ)` where `Σ` is the character set size)

---

## Java Solution

```java
class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] ch = s.toCharArray();
        int back = 0;
        int size = -1;

        for (int i = 0; i < ch.length; i++) {

            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }

            while (map.size() > k) {
                char left = ch[back++];

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }
            }

            if (map.size() == k) {
                size = Math.max(size, i - back + 1);
            }
        }

        return size;
    }
}
```

---

## Key Idea

Maintain a sliding window that never contains more than `k` distinct characters.

- Expand the window by moving the right pointer.
- Shrink the window whenever distinct characters exceed `k`.
- Record the maximum window length whenever there are exactly `k` distinct characters.

This guarantees an **O(n)** solution.

