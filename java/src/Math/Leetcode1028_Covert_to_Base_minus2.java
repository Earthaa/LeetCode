package Math;

public class Leetcode1028_Covert_to_Base_minus2 {
    public String baseNeg2(int N) {
        if(N == 0)
            return "0";
        String res = "";
        int count = 0;
        while (N != 0){
            int remain = N % 2;
            res = Integer.toString(remain) + res;
            N /= 2;
            N = count % 2 == 0 ? N : N + remain;
            count++;
        }
        return res;
    }
}
