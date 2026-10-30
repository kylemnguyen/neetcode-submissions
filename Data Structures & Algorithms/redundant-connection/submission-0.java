class DSU {
    int parent[];
    int rank[];

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    public int find(int n) {
        int p = parent[n];
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) {
            return false;
        } 
        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
            rank[pu] += rank[pv];
        } else {
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length + 1);

        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) return new int[]{edge[0], edge[1]};
        }

        return new int[0];

    }
}
