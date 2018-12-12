public class LeetCode289_Game_of_Life {
    private int update(int[][]board, int row, int col){
        int count = 0;
        if(row - 1 >= 0 && (board[row - 1][col] == 1 || board[row - 1][col] == -1))
            count++;
        if(row + 1 < board.length &&(board[row + 1][col] == 1 ||board[row + 1][col] == -1))
            count++;
        if(col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == -1))
            count++;
        if(col + 1 < board[0].length &&(board[row][col + 1] == 1 ||board[row][col + 1] == -1))
            count++;
        if(row - 1 >= 0 && col - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == -1))
            count++;
        if(row + 1 < board.length && col + 1 < board[0].length &&(board[row + 1][col + 1] == 1 ||board[row + 1][col + 1] == -1))
            count++;
        if(row - 1 >= 0 && col + 1 < board[0].length && (board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == -1))
            count++;
        if(row + 1 < board.length && col - 1 >= 0 &&(board[row + 1][col - 1] == 1 ||board[row + 1][col - 1] == -1))
            count++;
        if(board[row][col] == 1 && (count < 2 || count > 3))
            return -1;
        else if(board[row][col] == 0 && count == 3)
            return 2;
        else
            return board[row][col];
    }

    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                board[row][col] = update(board,row,col);
            }
        }
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == 2)
                    board[row][col] = 1;
                else if(board[row][col] == -1)
                    board[row][col] = 0;
            }
        }
    }
}
