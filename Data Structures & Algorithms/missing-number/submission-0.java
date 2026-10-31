class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i <= nums.length; i++) {
            set.add(i);
        }

        for(int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
            }
        }

        return set.iterator().next();
    }
}
