public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int minSpeed = Arrays.stream(piles).max().getAsInt();
        int right = minSpeed;

        while ( left <= right ) {
            int speed = (right + left) / 2;

            long hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double)p / speed);
            }

            if(hours <= h) {
                minSpeed = speed;
                right = speed - 1;
            } else {
                left = speed + 1;
            }

        }

        return minSpeed;
    }
}