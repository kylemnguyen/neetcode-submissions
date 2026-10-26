class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    public void backtrack(List<Integer> perm, int[] nums, boolean[] picked) {
        if(perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!picked[i]) {
                perm.add(nums[i]);
                picked[i] = true;
                backtrack(perm, nums, picked);
                perm.remove(perm.size() - 1);
                picked[i] = false;
            }
        }
    }
} 
