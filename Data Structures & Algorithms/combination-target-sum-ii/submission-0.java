class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // similar to combination sum I
        // do a dfs, but this time strictly do it such that we never go down the path that allows us to choose the same element twice
        // do a check if int i is in the list, if so skip to i+1
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target);
        return ans;
    }

    public void dfs(int[] candidates, int i, int total, int target) {
        if(target == total) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(i == candidates.length || total > target) {
            return;
        }

        // here we would have two checks, keep incrementing i until candidates[i] is not in subset
        // add it, if not go down the route where we don't add it.


        subset.add(candidates[i]);
        dfs(candidates, i + 1, total + candidates[i], target);
        subset.remove(subset.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, i + 1, total, target);
    }

}
