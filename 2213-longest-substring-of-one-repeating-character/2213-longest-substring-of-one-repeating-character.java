class Solution {

    class Node {
        int len;
        int pref;
        int suff;
        int size;

        char left;
        char right;
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters,
                                  int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(1, 0, n - 1,
                   queryIndices[i],
                   queryCharacters.charAt(i));

            ans[i] = tree[1].len;
        }

        return ans;
    }

    private void build(int idx, int l, int r) {

        tree[idx] = new Node();

        if (l == r) {
            tree[idx].len = 1;
            tree[idx].pref = 1;
            tree[idx].suff = 1;
            tree[idx].size = 1;

            tree[idx].left = arr[l];
            tree[idx].right = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private void update(int idx, int l, int r,
                        int pos, char ch) {

        if (l == r) {

            arr[pos] = ch;

            tree[idx].len = 1;
            tree[idx].pref = 1;
            tree[idx].suff = 1;
            tree[idx].size = 1;

            tree[idx].left = ch;
            tree[idx].right = ch;

            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(idx * 2, l, mid, pos, ch);
        } else {
            update(idx * 2 + 1, mid + 1, r, pos, ch);
        }

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node();

        res.size = a.size + b.size;

        res.left = a.left;
        res.right = b.right;

        res.pref = a.pref;
        if (a.pref == a.size && a.right == b.left) {
            res.pref = a.size + b.pref;
        }

        res.suff = b.suff;
        if (b.suff == b.size && a.right == b.left) {
            res.suff = b.size + a.suff;
        }

        res.len = Math.max(a.len, b.len);

        if (a.right == b.left) {
            res.len = Math.max(res.len,
                               a.suff + b.pref);
        }

        return res;
    }
}