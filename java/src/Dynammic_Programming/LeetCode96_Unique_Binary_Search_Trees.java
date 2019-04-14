package Dynammic_Programming;

public class LeetCode96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for(int i = 2; i <=n; i++){
            for(int pivot = 1; pivot <= i; pivot++){
                num[i] += (num[i - pivot] * num[pivot - 1]);
            }
        }
        return num[n];
    }
}
