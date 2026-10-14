public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> weather = new Stack<>();

        for(int i = 0; i < temperatures.length; i++ ) {
            while(!weather.isEmpty() && temperatures[weather.peek()] < temperatures[i]) {
                int j = weather.pop();
                days[j] = i - j;
            }
            weather.push(i);
        }

        return days;
    }
}