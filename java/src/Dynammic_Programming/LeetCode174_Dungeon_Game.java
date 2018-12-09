package Dynammic_Programming;

public class LeetCode174_Dungeon_Game {
    public int calculateMinimumHP(int[][] dungeon) {
        int numRow = dungeon.length;
        int numCol = dungeon[0].length;
        int[][] dp = new int[numRow][numCol];//To save the Initial hp should have in dungeon[row][col]
        for(int row = numRow - 1; row >= 0; row--){
            for(int col = numCol - 1; col >= 0; col--){
                int down = Integer.MAX_VALUE;int right = Integer.MAX_VALUE;
                if(row + 1 < numRow)
                    down = dp[row + 1][col];
                if(col + 1 < numCol)
                    right = dp[row][col + 1];
                //Right buttom choose should be Integer.MAX_VALUE
                int choose = Math.min(down,right);
                dp[row][col] = dungeon[row][col] >= 0 ? 1 : 1 - dungeon[row][col];

                if(choose != Integer.MAX_VALUE && dp[row][col] + dungeon[row][col] < choose){//The current initial hp is not enough in order to go further
                    dp[row][col] = choose - dungeon[row][col];
                }
            }
        }

        return dp[0][0];
    }
}
