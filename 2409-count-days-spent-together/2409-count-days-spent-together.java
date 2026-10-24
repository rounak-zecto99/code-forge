class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int start = Math.max(convert(arriveAlice), convert(arriveBob));
        int end = Math.min(convert(leaveAlice), convert(leaveBob));

        return Math.max(0, end - start + 1);
    }

    private int convert(String date) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        return day;
    }
}