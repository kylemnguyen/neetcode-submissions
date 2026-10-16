class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];

                if(threeSum > 0) {
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }

            }


        }

        return ans;

    }
}
