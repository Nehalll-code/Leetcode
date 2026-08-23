class Solution {

    public boolean isCycle(int src, boolean[] vis, boolean[] recPath,
                           int[][] prerequisites) {

        vis[src] = true;
        recPath[src] = true;

        // Find all neighbors of src
        for(int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            // prerequisite -> course
            if(prerequisite == src) {

                int v = course;

                if(!vis[v]) {

                    if(isCycle(v, vis, recPath, prerequisites)) {
                        return true;
                    }

                } else if(recPath[v]) {

                    return true;
                }
            }
        }

        recPath[src] = false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] vis = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {

            if(!vis[i]) {

                if(isCycle(i, vis, recPath, prerequisites)) {
                    return false;
                }
            }
        }

        return true;
    }
}