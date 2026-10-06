class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // number : index
        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if(map.containsKey(Integer.valueOf(difference))) {
                answer[0] = map.get(Integer.valueOf(difference));
                answer[1] = i;
                return answer;
            }

            map.put(nums[i], i);
        }

        return answer;
    }
}
