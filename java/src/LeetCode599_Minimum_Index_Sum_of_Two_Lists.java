import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode599_Minimum_Index_Sum_of_Two_Lists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> myMap = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            myMap.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        List<String> tmp = new LinkedList<>();
        for(int i = 0; i < list2.length; i++){
            if(myMap.containsKey(list2[i])){
                int indexSum = myMap.get(list2[i])+i;
                if(min > indexSum){
                    tmp = new LinkedList<>();
                    tmp.add(list2[i]);
                    min = indexSum;
                }
                else if(min == indexSum)
                    tmp.add(list2[i]);
            }
        }
        int[] t = {1,2};
        String[] res = new String[tmp.size()];
        return tmp.toArray(res);

    }
}
