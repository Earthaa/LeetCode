//find the underlying routine of problem
public class LeetCode598_Range_Addition_II {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0)
            return m * n;
        int maxM = Integer.MAX_VALUE;
        int maxN = Integer.MAX_VALUE;
        for(int[] op:ops){
            maxM = Math.min(maxM,op[0]);
            maxN = Math.min(maxN,op[1]);
        }
        return maxM * maxN;

    }
}
