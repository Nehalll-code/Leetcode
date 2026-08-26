class Solution {

    public boolean dfs(int i, int[][] graph, int[] vis, int[] pathvis, int[] check) {

        vis[i] = 1;
        pathvis[i] = 1;
        check[i] = 0;

        for(int it : graph[i]) {

            if(vis[it] == 0) {

                if(dfs(it, graph, vis, pathvis, check)) {
                    return true;
                }

            }
            else if(pathvis[it] == 1) {
                return true;
            }
        }

        check[i] = 1;
        pathvis[i] = 0;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check = new int[V];

        for(int i = 0; i < V; i++) {

            if(vis[i] == 0) {
                dfs(i, graph, vis, pathvis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++) {

            if(check[i] == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}