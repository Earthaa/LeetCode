import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if(citations.length == 0)
            return 0;
        int hIndex = 0;
        for(int i = citations.length - 1; i >= 0; i--)
        {
            if(citations[i] <= hIndex)
                return hIndex;
            hIndex++;
        }
        return hIndex;
    }
}
