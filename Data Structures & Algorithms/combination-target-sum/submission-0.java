class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, 0, target);
        return ans;
    }

    public void dfs(int[] nums, int i, int total, int target) {
        if (total == target) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        if (i >= nums.length || total > target) {
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i, total + nums[i], target);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, total, target);
    }
}
