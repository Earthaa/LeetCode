import java.util.*;
public class LeetCode364_Nested_List_Weight_SumII {
    private int sum = 0;
    private int totalLayer = 0;
    private void getTotalLayer(List<NestedInteger> nestedList, int curLayer){
        totalLayer = Math.max(totalLayer,curLayer);
        for(NestedInteger each:nestedList){
            if(!each.isInteger())
                getTotalLayer(each.getList(),curLayer + 1);
        }
    }

    private void countWeightSum(List<NestedInteger> nestedList, int weight){
        for(NestedInteger each:nestedList){
            if(each.isInteger())
                sum += each.getInteger() * weight;
            else
                countWeightSum(each.getList(),weight - 1);
        }
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        getTotalLayer(nestedList,1);
        countWeightSum(nestedList,totalLayer);
        return sum;
    }
}
