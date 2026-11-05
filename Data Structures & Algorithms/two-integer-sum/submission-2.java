class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if(map.containsKey(remainder)) {
                if(map.get(remainder) > i) {
                    return new int[]{i, map.get(remainder)};
                } else {
                    return new int[]{map.get(remainder), i};                    
                }
            }
            map.putIfAbsent(nums[i], i);
        }

        return new int[0];
    }
}
