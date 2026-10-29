class Solution {
    private List<Integer> output = new ArrayList<>();
    private int[] indegree;
    private List<List<Integer>> adj;

    public void dfs(int node) {
        output.add(node);
        indegree[node]--;
        for(int nei : adj.get(node)) {
            indegree[nei]--;
            if(indegree[nei] == 0) {
                dfs(nei);
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int prereq = pre[1];
            int crs = pre[0];
            adj.get(prereq).add(crs);
            indegree[crs]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                dfs(i);
            }
        }

        if (output.size() != numCourses) {
            return new int[0];
        }

        int[] ans = new int[numCourses];
        for(int i = 0; i < output.size(); i++) {
            ans[i] = output.get(i);
        }

        return ans;

    }
}
