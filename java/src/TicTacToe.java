public class TicTacToe {
    /** Initialize your data structure here. */
    char[][] board;
    int len;
    int win;
    public TicTacToe(int n) {
        board = new char[n][n];
        len = n;
        win = 0;
    }
    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(win != 0)
            return win;
        char cheese[] = {' ','X','O'};
        board[row][col] = cheese[player];
        boolean isRow = true;
        boolean isCol = true;
        boolean isDig = true;
        boolean isRDig =true;
        for(int i = 0; i < len; i++){
            if(board[row][i] != cheese[player]){
                isRow = false;
                break;
            }
        }
        for(int i = 0; i < len; i++) {
            if(board[i][col] != cheese[player]){
                isCol =false;
                break;
            }
        }

        if(col - row != 0 && col + row != len - 1){
            isDig = false;
            isRDig = false;
        }
        else{
            for(int i = 0; i < len; i++){
                if(board[i][i] != cheese[player]){
                    isDig = false;
                    break;
                }
            }
            for(int i = 0; i < len; i++) {
                if(board[i][len - i - 1] != cheese[player]){
                    isRDig = false;
                    break;
                }
            }
        }
        if(isCol || isDig || isRow || isRDig)
            win = player;
        return win;
    }
}
