package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode207_Course_Schedule {
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (matrix[from][to] == 0)
                indegree[to]++; //duplicate case
            matrix[from][to] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)//When all path to  node i has been already visited, then visit node i
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
    //DFS
//    private boolean DFS(int[][] matrix, int from, int[] visited,int[] preVisited,int numCourses){
//        if(visited[from] != 0)
//            return false;
//        visited[from] = 1;
//        preVisited[from] = 1;
//        boolean res = true;
//        for(int i = 0; i < numCourses; i++){
//            if(matrix[from][i] != 0){
//                res &= DFS(matrix, i,visited,preVisited,numCourses);
//                if(res == false)
//                    return res;
//            }
//        }
//        visited[from] = 0;
//        return res;
//    }
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if(numCourses == 0)
//            return true;
//        int[][] matrix = new int[numCourses][numCourses];
//        int[] inDegree = new int [numCourses];
//        for(int[] edge:prerequisites){
//            int to = edge[0];
//            int from = edge[1];
//            matrix[from][to] = 1;
//            inDegree[to]++;
//        }
//        int[] preVisited = new int[numCourses];
//        int[] visited = new int[numCourses];
//        for(int i = 0; i < numCourses; i++){
//            if(inDegree[i] == 0){
//                visited = new int[numCourses];
//                if(!DFS(matrix,i,visited,preVisited,numCourses))
//                    return false;
//            }
//        }
//        for(int i = 0; i < numCourses; i++){
//            if(preVisited[i] == 0)
//                return false;
//        }
//        return true;
//    }
}
