class Solution {
    public int countCollisions(String directions) {
        int collision = 0;
        int n = directions.length();

        Character[] stack = new Character[n];
        int top = -1;

        for (char ch : directions.toCharArray()) {
            if (ch == 'R') {
                stack[++top] = ch;
                continue;
            } else if (ch == 'L') {
                if (top != -1 && stack[top] == 'R') {
                    collision += 2;
                    top--;

                    while (top != -1 && stack[top] == 'R') {
                        collision++;
                        top--;
                    }

                    stack[++top] = 'S';
                } else if (top != -1) {
                    collision++;
                }
            } else {
                while (top != -1 && stack[top] == 'R') {
                    collision++;
                    top--;
                }
                stack[++top] = 'S';
            }
        }
        return collision;
    }
}