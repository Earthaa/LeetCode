import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class findStrobogrammatic {
    Map<Character,Character> myMap = new HashMap<Character, Character>();
    List<String> res = new ArrayList<String>();
    private void getString(String first, String second, int n)
    {
        if(n == 0)
            res.add(first + second);
        else if(n == 1) {
            for (Character each : myMap.keySet())
                if (each.equals(myMap.get(each)))
                    res.add(first + each.toString() + second);
        }
        else
        {
            for(Character each:myMap.keySet())
            {
                if(first.length() == 0 && each.equals('0'))
                    continue;
                String newFirst  = first + each.toString();
                String newSecond = myMap.get(each).toString() + second;
                getString(newFirst, newSecond, n - 2);
            }
        }
    }
    public List<String> findStrobogrammatic(int n) {
        myMap.put('0','0');
        myMap.put('1','1');
        myMap.put('6','9');
        myMap.put('9','6');
        myMap.put('8','8');
        getString("","",n);
        return this.res;
    }
}
