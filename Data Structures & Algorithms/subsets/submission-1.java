class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		dfs(nums, 0, subset, ans);
		return ans;
    }
	
	public void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> ans) {
		if(i >= nums.length) {
			ans.add(new ArrayList<>(subset));
			return;
		}
		
		subset.add(nums[i]);
		dfs(nums, i+1, subset, ans);
		subset.remove(subset.size() - 1);
		dfs(nums, i+1, subset, ans);
	}
}
