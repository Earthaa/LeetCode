import java.util.*;
class TwoSum {
    Map<Integer,Integer> table;
    /** Initialize your data structure here. */
    public TwoSum() {
        table = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!table.containsKey(number))
            table.put(number,1);
        else
            table.put(number,table.get(number) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Integer> it = table.keySet().iterator();
        while(it.hasNext()){
            int num1 = it.next();
            int num2 = value - num1;
            //System.out.println(table.containsKey(num2));
            if(num2 == num1){
                if(table.get(num1) > 1)
                    return true;}
            else{
                if(table.containsKey(num2))
                    return true;
            }
        }
        return false;
    }
}
