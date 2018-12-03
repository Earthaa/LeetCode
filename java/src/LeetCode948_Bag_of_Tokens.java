import java.util.*;
public class LeetCode948_Bag_of_Tokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        int maxPoints = 0;
        if(tokens.length == 0)
            return maxPoints;
        else if(tokens.length == 1)
            return P >= tokens[0] ? 1 : 0;

        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        while(i < j){
            if(P < tokens[i])
                break;
            int sumPower = 0;
            int k = i;
            while(k <= j){
                if(sumPower + tokens[k] > P)
                    break;
                sumPower += tokens[k];
                ++k;
            }
            maxPoints = Math.max(k - i, maxPoints);
            if(k == j + 1)
                break;
            P = P - tokens[i] + tokens[j];
            i++;
            j--;
        }
        return maxPoints;
    }
}
