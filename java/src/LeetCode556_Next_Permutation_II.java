public class LeetCode556_Next_Permutation_II {
    private void nextPermutation(char[] digits, int start){
        for(int i = digits.length - 1; i > start; i--){
            if(digits[i] > digits[start]){
                char tmp = digits[i];
                digits[i] = digits[start];
                digits[start] = tmp;
                break;
            }
        }
        int i = start + 1;
        int j = digits.length - 1;
        while(i < j){
            if(digits[i] > digits[j]){
                char tmp = digits[i];
                digits[i] = digits[j];
                digits[j] = tmp;
            }
            i++; j--;
        }
        //return digits;
    }
    public int nextGreaterElement(int n) {
        if(n < 10)
            return -1;
        String num = Integer.toString(n);
        char[] digits = new char[num.length()];
        for(int i = 0; i < num.length(); i++){
            digits[i] = num.charAt(i);
        }
        boolean find = false;
        int start = 0;
        for(int i = digits.length - 1; i > 0; i--){
            if(digits[i - 1] < digits[i]){
                find = true;
                start = i - 1;
                break;
            }
        }
        if(find == false)
            return -1;
        nextPermutation(digits,start);
        String resStr = "";
        for(int i = 0; i < digits.length; i++)
            resStr += Character.toString(digits[i]);
        long res = Long.parseLong(resStr);
        if(res > Integer.MAX_VALUE)
            return -1;
        int intRes = Integer.parseInt(resStr);
        return intRes;


    }
}
