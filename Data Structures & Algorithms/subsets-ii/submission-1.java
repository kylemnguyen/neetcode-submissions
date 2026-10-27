class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, int i, List<Integer> subset) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i += 1;
        }
        backtrack(nums, i + 1, subset);
    }
}
