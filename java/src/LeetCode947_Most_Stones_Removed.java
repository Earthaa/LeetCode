import java.util.*;
public class LeetCode947_Most_Stones_Removed {
    public int findRoot(int[] union, int find){
        while (find != union[find]){
            find = union[find];
        }
        return find;
    }

    public int removeStones(int[][] stones) {
        int[] union = new int[20000];
        //Arrays.sort(stones,(a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < union.length; i++)
            union[i] = i;
        for(int each = 0; each < stones.length; each++){
            int row = stones[each][0];
            int col = stones[each][1] + 10000;
            if(union[col] > 10000)
                union[col] = union[row];
            else{
                int rowRoot = findRoot(union,row);
                int colRoot = findRoot(union,col);
                union[rowRoot] = Math.min(rowRoot,colRoot);
                union[colRoot] = Math.min(rowRoot,colRoot);
            }
        }
        Map<Integer,Integer> doCount = new HashMap<>();
        int componentCount = 0;
        for(int each = 0; each < stones.length; each++){
            int row = stones[each][0];
            int root = findRoot(union,row);
            if(!doCount.containsKey(root)){
                doCount.put(root,1);
                ++componentCount;
            }
        }
        return stones.length - componentCount;
    }
}
