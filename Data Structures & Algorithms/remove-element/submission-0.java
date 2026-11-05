class Solution {
    public int removeElement(int[] nums, int val) {
        int amount = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[amount++] = nums[i];
            }
        }

        return amount;
    }
}