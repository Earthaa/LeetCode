package Math;

public class LeetCode923_3Sum_With_Multiplicity {
    public int threeSumMulti(int[] A, int target) {
        long mod = 1000000007;
        long res = 0;
        long[] map = new long[101];
        for(int i = 0; i <= A.length - 1; i++){
            map[A[i]] += 1;
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                for(int j = i; j < map.length;j++){
                    if(map[j] != 0){
                        int k = target - i - j;
                        if(k >= 0 && k <= 100 && map[k] != 0){
                            if(i == j && j == k)
                                res = res + (map[i] * (map[i] - 1) * ( map[i] - 2)) / 6;
                            else if(i == j && j < k)
                                res = res + (map[i] * (map[i] - 1)) / 2 * map[k];
                            else if(j == k)
                                res = res + map[i] * (map[j] * (map[j] - 1)) / 2;
                            else if(j < k)
                                res = res + map[i] * map[j] * map[k];
                        }
                    }
                }
            }
        }
        return (int)(res % mod);
    }
}
