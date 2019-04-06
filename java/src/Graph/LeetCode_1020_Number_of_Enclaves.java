package Graph;

public class LeetCode_1020_Number_of_Enclaves {
    private int M;
    private int N;
    public int numEnclaves(int[][] A) {
        M = A.length;
        N = A[0].length;
        int[][] visited = new int[M][N];
        for(int col = 0; col < N; col++){
            DFS(A, visited, 0, col);
            DFS(A,visited,M -1,col);
        }
        for(int row = 0; row < M; row++){
            DFS(A,visited,row,0);
            DFS(A,visited,row,N - 1);
        }
        int count = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++)
            {
                if(visited[i][j] == 0 && A[i][j] == 1)
                    count++;
            }
        }
        return count;

    }
    private void DFS(int[][] A, int[][] visited,int row, int col){
        if(row < 0 || row > M -1 || col < 0 || col > N - 1 || A[row][col] == 0 || visited[row][col] == 1)
            return;
        visited[row][col] = 1;
        DFS(A,visited,row + 1,col);
        DFS(A,visited,row - 1,col);
        DFS(A,visited,row, col + 1);
        DFS(A,visited,row, col - 1);
    }
}
