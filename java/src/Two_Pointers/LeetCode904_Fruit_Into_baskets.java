package Two_Pointers;

public class LeetCode904_Fruit_Into_baskets {
    public int totalFruit(int[] tree) {
        int type1 = -1;
        int type2 = -1;
        int type1Start = -1;
        int type2Start = -1;
        int start = 0;
        int maxCount = Integer.MIN_VALUE;
        int lasttype = -1;
        for(int i = 0; i < tree.length; i++){
            if(tree[i] != lasttype){
                lasttype = tree[i];
                if(tree[i] != type1 && tree[i] != type2){
                    //Initialize
                    type1 = (type1 == -1) ? tree[i] : type1;
                    type1Start = (type1 == -1) ? i : type1Start;
                    type2 = (type2 == -1 && type1 != -1) ? tree[i] : type2;
                    type2Start = (type2 == -1 && type1 != -1) ? i :type2Start;
                    //Nearest last type
                    int nearestStart = Math.max(type1Start,type2Start);
                    if(type1Start != -1 && type2Start != -1){
                        maxCount = Math.max(maxCount,i - start);
                        start = nearestStart;
                    }
                    if(type1Start == nearestStart){
                        type2 = tree[i];
                        type2Start = i;
                    }
                    else{
                        type1 = tree[i];
                        type1Start = i;
                    }
                }
                else if(tree[i] != type1){
                    type2Start = i;
                }
                else{
                    type1Start = i;
                }
            }
        }

        maxCount = Math.max(maxCount, tree.length - start);
        return maxCount;


//        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
//        int res = 0, i = 0;
//        for (int j = 0; j < tree.length; ++j) {
//            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
//            while (count.size() > 2) {
//                count.put(tree[i], count.get(tree[i]) - 1);
//                if (count.get(tree[i]) == 0) count.remove(tree[i]);
//                i++;
//            }
//            res = Math.max(res, j - i + 1);
//        }
//        return res;
    }

}
