class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> numbers = new HashSet<>();

        for(int i : nums) {
            numbers.add(i);
        }

        for(int i = 0; i < nums.length; i++) {

            if(!numbers.contains(nums[i] - 1)) {
                int start = nums[i];
                int count = 1;
                while(numbers.contains(start + 1)) {
                    count++;
                    start++;
                }
                answer = (count > answer) ? count : answer;
            }

        }


        return answer;   
    }
}
