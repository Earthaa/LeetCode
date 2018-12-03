public class DeleteColumns {
    public int minDeletionSize(String[] A) {
        int res = 0;
        if(A.length <= 1)
            return res;
        for(int col = 0; col < A[0].length(); col++) {
            for(int row = 0; row < A.length - 1; row++){
                if(A[row].charAt(col) > A[row + 1].charAt(col)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
