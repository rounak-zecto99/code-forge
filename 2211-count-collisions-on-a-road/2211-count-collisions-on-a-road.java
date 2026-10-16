class Solution {
    public int countCollisions(String directions) {
        int collision = 0;

        int left = 0;
        int right = directions.length() - 1;

        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }

        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        for (int i = left; i <= right; i++) {
            char ch = directions.charAt(i);

            if (ch != 'S')
                collision++;
        }
        return collision;
    }
}