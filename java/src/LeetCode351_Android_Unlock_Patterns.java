public class LeetCode351_Android_Unlock_Patterns {
    int[][] hasVisted;
    int totalCount;
    int maxNum;
    int minNum;
    public int numberOfPatterns(int m, int n) {
        hasVisted = new int[3][3];
        totalCount = 0;
        minNum = m;
        maxNum = n;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                DFS(i,j,0);
        return totalCount;
    }
    private boolean canVisit(int fromX, int fromY, int toX, int toY){
        if(fromX == toX && Math.abs(toY - fromY) == 2 &&
                hasVisted[fromX][(fromY+toY)/2] != 1)//X bound
            return false;

        else if(fromY == toY && Math.abs(toX - fromX) == 2 &&
        hasVisted[(fromX + toX)/2][fromY] != 1)//Y bound
            return false;

        else if(fromX == fromY && toX == toY && Math.abs(fromX-toX) == 2
        && hasVisted[(fromX+toX)/2][(fromY+toY)/2] != 1)
            return false;//Positive Diagonal

        else if(fromX + fromY == 2 && toX + toY == 2 && Math.abs(fromX -toX) == 2
        && hasVisted[(fromX + toX)/2][(fromY + toY)/2] != 1)
            return false;//Negative Diagonal

        else
            return true;
    }
    private void DFS(int x, int y, int nodeNum){
        nodeNum++;
        hasVisted[x][y] = 1;
        if(nodeNum >= minNum)
            totalCount++;
        if(nodeNum == maxNum) {
            hasVisted[x][y] = 0;
            return;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(hasVisted[i][j] == 0 && canVisit(x,y,i,j))
                    DFS(i,j,nodeNum);
            }
        }
        hasVisted[x][y] = 0;
    }
}
