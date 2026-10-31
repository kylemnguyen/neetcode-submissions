class Solution {
    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        int ans = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            if( ans > MAX / 10 || (ans == MAX && digit >= MAX % 10)) return 0;
            if( ans < MIN / 10 || (ans == MIN && digit <= MIN % 10)) return 0;
            ans = (ans * 10) + digit;
        }

        return ans;
    }
}
