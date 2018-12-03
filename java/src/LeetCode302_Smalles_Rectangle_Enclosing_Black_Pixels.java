public class LeetCode302_Smalles_Rectangle_Enclosing_Black_Pixels {
    int left,right,up,down;
    int width,len;
    void DFS(char[][] image, int x, int y){
        left = Math.min(left,y);
        right = Math.max(right,y);
        up = Math.min(up,x);
        down = Math.max(down,x);
        image[x][y] = 'V';
        if(x - 1 >= 0 && image[x - 1][y] == '1')
            DFS(image,x - 1,y);
        if(x + 1 < len && image[x + 1][y] == '1')
            DFS(image,x + 1,y);
        if(y - 1 >= 0 && image[x][y - 1] == '1')
            DFS(image,x,y - 1);
        if(y + 1 < width && image[x][y + 1] == '1')
            DFS(image,x,y + 1);
    }
    public int minArea(char[][] image, int x, int y) {
        width = image[0].length;
        len = image.length;
        left = Integer.MAX_VALUE;
        right = Integer.MIN_VALUE;
        up = Integer.MAX_VALUE;
        down = Integer.MIN_VALUE;
        DFS(image,x,y);
        return (right - left + 1)*(down - up + 1);
    }
}
