public class LeetCode1003_Check_If_Word_Is_Valid_After_Sbustition {
    public boolean isValid(String S) {
        if(S.length() % 3 != 0)
            return false;
        char[] stack = new char[S.length()];
        int sp = 0;
        for(int i = 0; i < S.length(); i++){
            stack[sp] = S.charAt(i);
            if(sp >= 2 && stack[sp] == 'c' && stack[sp - 1] == 'b' && stack[sp - 2] == 'a')
                sp -= 2;
            else
                sp++;
        }
        return sp == 0;

    }
}
