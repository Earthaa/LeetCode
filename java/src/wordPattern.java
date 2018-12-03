import java.util.*;
public class wordPattern {
    private boolean isMatch(String pattern, String str, int startPa,int startStr, Map<Character,String> myMap,Map<String,Character> myMap2){
        if(startPa == pattern.length() - 1){
            if(myMap.get(pattern.charAt(startPa)) == null && myMap2.get(str.substring(startStr)) == null)
                return true;
            String subStr = str.substring(startStr);
            if(subStr.equals(myMap.get(pattern.charAt(startPa))))
                return true;
            return false;
        }
        if(myMap.get(pattern.charAt(startPa)) != null)
        {
            String myStr = myMap.get(pattern.charAt(startPa));
            int nextStartStr = startStr + myStr.length();
            if(nextStartStr >= str.length())
                return false;
            else if(!str.substring(startStr,nextStartStr).equals(myStr))
                return false;
            return isMatch(pattern,str,startPa+1,nextStartStr,myMap,myMap2);
        }
        boolean flag = false;
        for(int i = startStr + 1; (str.length() - i) >= (pattern.length() - startPa) - 1; i++){
            myMap.put(pattern.charAt(startPa), str.substring(startStr,i));
            myMap2.put(str.substring(startStr,i),pattern.charAt(startPa));
            flag |= isMatch(pattern,str,startPa + 1,i,myMap,myMap2);
            if(flag == true)
                break;
            myMap.remove(pattern.charAt(startPa));
            myMap2.remove(str.substring(startStr,i));
        }
        return flag;
    }
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.equals("") && str.equals(""))
            return true;
        else if(pattern.equals(""))
            return false;
        else if(pattern.length() > str.length())
            return false;
        Map<Character,String> myMap = new HashMap<Character, String>();
        Map<String,Character> myMap2 = new HashMap<String,Character>();
        return isMatch(pattern,str,0,0,myMap,myMap2);
    }
}
