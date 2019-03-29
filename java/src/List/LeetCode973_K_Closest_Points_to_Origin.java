package List;

public class LeetCode973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int r = points.length - 1;
        while(true){
            int index = partrition(points,l,r);
            if(index > K -1){
                r = index - 1;
            }
            else if(index < K - 1){
                l = index + 1;
            }
            else
                break;
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K;i++){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
    private int partrition(int[][] points, int l, int r){
        int pivot = l;
        while(l != r){
            while(distance(points,r) > distance(points,pivot) && r > l)
                r--;
            swap(points,pivot,r);
            pivot = r;
            while(distance(points,l)<=distance(points,pivot) && r > l)
                l++;
            swap(points,pivot,l);
            pivot = l;
        }
        return l;
    }
    private int distance(int[][] points, int index){
        return (int)Math.pow(points[index][0],2) + (int)Math.pow(points[index][1],2);
    }
    private void swap(int[][] points, int id1,int id2){
        int x = points[id1][0];
        int y = points[id1][1];
        points[id1][0] = points[id2][0];
        points[id1][1] = points[id2][1];
        points[id2][1] = y;
        points[id2][0] = x;
    }
}
