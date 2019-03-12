import java.util.*;
public class LeetCode1001_Grid_Illumination {
    Map<Integer,Integer> rowMap = new HashMap<>();
    Map<Integer,Integer> colMap = new HashMap<>();
    Map<Integer, Integer> digMap1 = new HashMap<>();
    Map<Integer, Integer> digMap2 = new HashMap<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int N;
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        this.N = N;
        for(int i = 0; i < lamps.length; i++){
            int row = lamps[i][0];
            int col = lamps[i][1];
            int dig1 = row - col;
            int dig2 = row + col;
            if(graph.get(row) == null){
                Set<Integer> myset = new HashSet<>();
                myset.add(col);
                graph.put(row,myset);
            }
            else{
                Set<Integer> myset = graph.get(row);
                myset.add(col);
                graph.put(row,myset);
            }
            if (rowMap.get(row) == null) {
                rowMap.put(row, 1);
            } else {
                rowMap.put(row, rowMap.get(row) + 1);
            }
            if (colMap.get(col) == null) {
                colMap.put(col, 1);
            } else {
                colMap.put(col, colMap.get(col) + 1);
            }
            if (digMap1.get(dig1) == null) {
                digMap1.put(dig1, 1);
            } else {
                digMap1.put(dig1, digMap1.get(dig1) + 1);
            }
            if (digMap2.get(dig2) == null) {
                digMap2.put(dig2, 1);
            } else {
                digMap2.put(dig2, digMap2.get(dig2) + 1);
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int row = queries[i][0];
            int col = queries[i][1];
            if(isIlluminated(row, col))
                res[i] = 1;
            else
                res[i] = 0;
            removeLight(row,col);
            removeLight(row + 1,col);
            removeLight(row - 1,col);
            removeLight(row,col + 1);
            removeLight(row,col - 1);

            removeLight(row - 1,col - 1);
            removeLight(row - 1,col + 1);
            removeLight(row + 1,col + 1);
            removeLight(row + 1,col - 1);

        }
        return res;

    }
    private void removeLight(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= N)
            return;
        Set<Integer> rowSet = graph.get(row);
        if(rowSet == null || ! rowSet.contains(col))
            return;
        rowSet.remove(col);
        int dig1 = row - col;
        int dig2 = row + col;
        rowMap.put(row,rowMap.get(row) - 1);
        colMap.put(col,colMap.get(col) - 1);
        digMap1.put(dig1, digMap1.get(dig1) - 1);
        digMap2.put(dig2, digMap2.get(dig2) - 1);

    }
    private boolean isIlluminated(int row, int col){
        int dig1 = row - col;
        int dig2 = row + col;
        boolean rowValid = rowMap.get(row) != null && rowMap.get(row) > 0;
        boolean colValid = colMap.get(col) != null && colMap.get(col) > 0;
        boolean dig1Valid = digMap1.get(dig1) != null && digMap1.get(dig1) > 0;
        boolean dig2Valid = digMap2.get(dig2) != null && digMap2.get(dig2) > 0;
        return rowValid || colValid || dig1Valid || dig2Valid;
    }


}
