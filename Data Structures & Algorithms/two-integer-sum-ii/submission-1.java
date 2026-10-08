class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int first = 0;
        int second = numbers.length - 1;

        while ( first < second ) {
            
            if(numbers[second] + numbers[first] > target) {
                second--;
            }
            else if (numbers[second] + numbers[first] < target) {
                first++;
            } 
            else {
                return new int[] {first + 1 , second + 1};
            }

       }

       return new int[] {};
        
    }
}
