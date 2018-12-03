public class MountainHighArray {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3)
            return false;
        int mIndex = 0;
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] == A[i + 1])
                return false;
            else if(A[i] > A[i + 1]) {
                mIndex = i ;
                break;
            }
        }
        if(mIndex == 0)
            return false;
        for(int i = mIndex; i < A.length - 1; i++){
            if(A[i] <= A[i + 1])
                return false;
        }
        return true;
    }
}
