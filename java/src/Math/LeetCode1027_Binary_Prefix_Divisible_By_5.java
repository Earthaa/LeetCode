package Math;
import java.util.*;
public class LeetCode1027_Binary_Prefix_Divisible_By_5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new LinkedList<>();
        String str = "";
        for(int i = 0; i < A.length; i++){
            str += Integer.toString(A[i]);
            int divisor = Integer.parseInt(str,2);
            if(divisor % 5 == 0) {
                res.add(true);
                str = "";
            }
            else{
                res.add(false);
                str = Integer.toBinaryString(divisor % 5);
            }
        }
        return res;
    }
}
