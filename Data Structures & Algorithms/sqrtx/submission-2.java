class Solution {
    public int mySqrt(int x) {
        int lower = 0;
        int higher = x;

        while(lower <= higher) {
            int middle = lower + (higher - lower) / 2;
            if((long) middle * middle > x) {
                higher = middle - 1;
            } else if ((long) middle * middle < x) {
                lower = middle + 1;
            } else {
                return middle;
            }
        }

        return lower - 1;
    }
}