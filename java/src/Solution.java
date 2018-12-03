import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character,Character> myMap = new HashMap<Character, Character>();
        myMap.put('0','0');
        myMap.put('1','1');
        myMap.put('6','9');
        myMap.put('9','6');
        myMap.put('8','8');
        int i = 0, j = num.length() - 1;
        do
        {
            if(!myMap.containsKey(num.charAt(i))||!myMap.get(num.charAt(i)).equals(num.charAt(j)))
                return false;
            i++;
            j--;
        }while(i <= j);
        return true;
    }

}