class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(visited, adj, i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(Set<Integer> visited, List<List<Integer>> adj, int node) {
        if(visited.contains(node)) {
            return;
        }
        
        visited.add(node);

        for(int nei : adj.get(node)) {
            dfs(visited, adj, nei);
        }
    }
}
