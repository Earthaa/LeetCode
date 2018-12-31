public class LeetCode498_Diagonal_Traverse {
    private int length;
    private int width;
    private int count;
    private int maxNum;
    private int[][] drawDiagonal(int[][] start,int[][] matrix, boolean traverse,int[] res){
        int row = start[0][0];
        int col = start[0][1];
        res[count] = matrix[row][col];
        count++;
        int[][] newStart = new int[1][2];
        if(traverse == true){//right to left
            while(row < width - 1 && col > 0){
                row++;
                col--;
                res[count] = matrix[row][col];
                count++;
            }
            if(col == 0 && row + 1 < width){
                newStart[0][0] = row + 1;
                newStart[0][1] = col;
            }
            else if(row == width - 1){
                newStart[0][0] = row;
                newStart[0][1] = col + 1;
            }
        }
        else{
            while(row > 0 && col < length - 1){
                row--;
                col++;
                res[count] = matrix[row][col];
                count++;
            }
            if(row == 0 && col + 1 < length){
                newStart[0][0] = row;
                newStart[0][1] = col + 1;
            }
            else if (col == length - 1){
                newStart[0][0] = row + 1;
                newStart[0][1] = col;
            }
        }
        return newStart;
    }
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        length = matrix[0].length;
        width = matrix.length;
        count = 0;
        maxNum = width * length;
        boolean traverse = false;
        int[][] start = new int[1][2];
        start[0][0] = 0;
        start[0][1] = 0;
        while(count < maxNum){
            start = drawDiagonal(start,matrix,traverse,res);
            traverse = !traverse;
        }
        return res;

    }
}
