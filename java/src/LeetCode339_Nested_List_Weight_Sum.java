import java.util.*;
public class LeetCode339_Nested_List_Weight_Sum {
    private int sum = 0;
    private void countWeightSum(List<NestedInteger> nestedList, int weight){
        for(NestedInteger each:nestedList){
            if(each.isInteger())
                sum += each.getInteger() * weight;
            else
                countWeightSum(each.getList(),weight + 1);
        }
    }
    public int depthSum(List<NestedInteger> nestedList) {
        countWeightSum(nestedList,1);
        return sum;
    }

}

