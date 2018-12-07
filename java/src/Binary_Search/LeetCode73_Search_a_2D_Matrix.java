package Binary_Search;

public class LeetCode73_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        for(int row = 0; row < matrix.length; row++){
            if(matrix[row][0] <= target && matrix[row][matrix[row].length - 1] >= target)
                return binarySearch(matrix[row], target);
        }
        return false;
    }
    private boolean binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        if(array[left] == target || array[right] == target)
            return true;
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(array[mid] == target)
                return true;
            else if(array[mid] < target)
                left = mid;
            else
                right = mid - 1;
        }
        return false;
    }
}
