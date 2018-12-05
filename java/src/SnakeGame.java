import java.util.*;
class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int[][] food;
    private int width;
    private int height;
    private int score;
    private Snake snake;
    private int foodNum;
    private class Point{
        int row;
        int col;
        Point(int row,int col){this.row = row; this.col = col;}
        boolean equals(Point another){
            if(this.row == another.row && this.col == another.col)
                return true;
            return false;
        }
    }
    private class Snake{
        LinkedList<Point> body ;
        Snake(){
            body = new LinkedList<Point>();
            body.add(new Point(0,0));
        }
        boolean isCollide(int row, int col){
            Point newPoint = new Point(row,col);
            for(Point point:body){
                if(point.equals(newPoint)){
                    return true;
                }
            }
            return false;
        }
        boolean moveTo(int row, int col){

            this.body.getLast().row = -1;
            this.body.getLast().col = -1;
            if(isCollide(row,col))
                return false;
            int newRow = row;
            int newCol = col;
            for(Point point:body){
                int lastRow = point.row;
                int lastCol = point.col;
                point.row = newRow;
                point.col = newCol;
                newRow = lastRow;
                newCol = lastCol;
            }
            return true;
        }
        Point getHead(){
            return body.peek();
        }
    }

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        this.score = 0;
        this.snake = new Snake();
        this.foodNum = 0;
    }
    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int newRow = 0;
        int newCol = 0;
        Point head = this.snake.getHead();
        if(direction.equals("U")){
            newRow = head.row - 1;
            newCol = head.col;
        }
        else if(direction.equals("L")){
            newRow = head.row;
            newCol = head.col - 1;
        }
        else if(direction.equals("R")){
            newRow = head.row;
            newCol = head.col + 1;
        }
        else if(direction.equals("D")){
            newRow = head.row + 1;
            newCol = head.col;
        }
        //System.out.println("newRow:  " + new Integer(newRow).toString() + "  newCol:  " + new Integer(newCol).toString());
        if(newRow >= this.height || newRow < 0 || newCol >= this.width || newCol < 0)
            return -1;
        if(foodNum < this.food.length && newRow == this.food[foodNum][0] && newCol == this.food[foodNum][1]){
            this.snake.body.addFirst(new Point(newRow,newCol));
            this.score++;
            this.foodNum++;
        }
        else if(!this.snake.moveTo(newRow,newCol)){
            return -1;
        }
        return this.score;
    }
}
