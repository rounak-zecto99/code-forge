class Solution {

    public ArrayList<Integer> isCircularPrime(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] composite = sieve(100000);

        for (int i = 2; i < n; i++) {
            if (!composite[i] && isCircular(i, composite)) {
                ans.add(i);
            }
        }

        return ans;
    }

    static boolean[] sieve(int n) {
        boolean[] composite = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!composite[i]) {
                for (int j = i * i; j < n; j += i) {
                    composite[j] = true;
                }
            }
        }

        return composite;
    }

    static boolean isCircular(int num, boolean[] composite) {
        int digits = String.valueOf(num).length();
        int power = (int) Math.pow(10, digits - 1);

        int x = num;

        for (int i = 0; i < digits; i++) {

            if (composite[x])
                return false;

            int last = x % 10;
            x = last * power + x / 10;
        }

        return true;
    }
}