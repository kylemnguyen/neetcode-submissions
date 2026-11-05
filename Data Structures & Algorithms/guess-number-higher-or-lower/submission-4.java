/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lower = 1;
        int higher = n;

        while(true) {
            int middle = lower + (higher - lower) / 2;
            if(guess(middle) == 0) {
                return middle;
            }
            if(guess(middle) == -1) {
                higher = middle - 1;
            } else if (guess(middle) == 1) {
                lower = middle + 1;
            }
        }
    }
}