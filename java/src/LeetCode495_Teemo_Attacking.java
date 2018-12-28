public class LeetCode495_Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length < 1)
            return 0;
        int totalDuration = 0;
        //int curDuration = 0;
        int curEnd = 0;
        int curStart = 0;
        for(int i = 0; i < timeSeries.length; i++){
            if(curEnd <= timeSeries[i]){
                totalDuration += (curEnd - curStart);
                curStart = timeSeries[i];
            }
            curEnd = timeSeries[i] + duration;
        }
        totalDuration += (curEnd - curStart);
        return totalDuration;

    }
}
