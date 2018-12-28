package Greedy;

public class LeetCode649_Dota2_Senate {
    public String predictPartyVictory(String senate) {
        int totalR = 0;
        int totalD = 0;
        int usingR = 0;
        int usingD = 0;

        StringBuffer s = new StringBuffer(senate);
        do{
            totalR = 0;
            totalD = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'R'){
                    if(usingD > 0){
                        s.setCharAt(i,'P');
                        usingD--;
                    }
                    else{
                        totalR++;
                        usingR++;
                    }
                }
                else if(s.charAt(i) == 'D'){
                    if(usingR > 0){
                        s.setCharAt(i,'P');
                        usingR--;
                    }
                    else{
                        totalD++;
                        usingD++;
                    }
                }
            }
        }while(totalR != 0 && totalD != 0);
        if(totalR > 0)
            return "Radiant";
        else
            return "Dire";
    }
}
