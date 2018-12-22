package Dynammic_Programming;

public class LeetCode132_Palindrome_PartitioningII {
    public int minCut(String s) {
        int n = s.length();
        boolean  dp[][] = new boolean[n][n];//判断是否是回文串
        int cut[] = new int[n];//存储最小cut值
        int min;
        for (int i = 0; i < n; i++) {//i是substring的尾部
            min = i;
            for (int j = 0; j <= i ; j++) {//j是substring的头部
                //j+1 > i-1表示对角线部分，也就是一个字符作为一个回文串substring
                if (s.charAt(i) == s.charAt(j) && (j+1 > i-1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if(j == 0)//表示尾部第i个和头部第一个字符相同，而且中间也是回文串，也就是这个串就是一个回文串，所以cut值直接就是0
                        min = 0;
                    else
                        //此时表示s.substring(j,i+1)是个回文串，也就是s[j]~s[i]之间的字符构成一个回文串
                        //注意关键在这个cut[j-1]而不是cut[i-1],
                        //cut[j-1]表示是s[j-1]之前的最小的cut值，
                        //此时是s[j]~s[i]是一个回文串，所以cut[i]之间从cut[j-1]加1即可
                        min = Math.min(min, cut[j-1]+1);
                }
            }
            cut[i] = min;
        }
        return cut[n-1];
    }
    /*
    * Here below is my code*/
//    public int minCut(String s) {
//        if(s.length() <= 1)
//            return 0;
//        int[][] dp = new int[s.length()][s.length()];
//        int[] cut = new int[s.length()];
//        int min = 0;
//        for(int end = 0; end < s.length(); end ++){
//            dp[end][end] = 1;
//            if(end == 0)
//                min = end;
//            else
//                min = cut[end - 1] + 1;
//            for(int start = 0; start < end; start++){
//                if(s.charAt(start) == s.charAt(end) && (start + 1 == end
//                        || dp[start + 1][end - 1] == 1)){
//                    dp[start][end] = 1;
//                    min =  start == 0 ? 0 : Math.min(min,cut[start - 1] + 1);
//                }
//            }
//            cut[end] = min;
//        }
//        return cut[s.length() - 1];
//    }
}
