public class numberToWords {
    public String numberInHundred(String num){
        String ans = "";
        if(num.equals("000"))
            return ans;
        while(num.charAt(0) == '0' && num.length() > 1)
            num = num.substring(1);
        if(num.length() == 1 && num.charAt(0)== '0')
            return "Zero";
        for(int i = num.length() - 1; i >=0 ; i--)
        {
            String str = "";
            if((i == 0 && num.length() == 3) || (i == num.length() - 1 && num.length() > 1
                    && num.charAt(i - 1) != '1') || num.length() == 1){
                switch (num.charAt(i)){
                    case '1': str = "One " ;break;
                    case '2': str = "Two ";break;
                    case '3': str = "Three " ;break;
                    case '4': str = "Four " ;break;
                    case '5': str = "Five " ;break;
                    case '6': str = "Six " ;break;
                    case '7': str = "Seven " ;break;
                    case '8': str = "Eight " ;break;
                    case '9': str = "Nine " ;break;
            }
            if (i == 0 && num.length() == 3)
                str += "Hundred ";
            }
            else if(i == num.length() - 2 && num.charAt(i) != '1')
                switch(num.charAt(i)){
                    case '2': str = "Twenty " ;break;
                    case '3': str = "Thirty " ;break;
                    case '4': str = "Forty " ;break;
                    case '5': str = "Fifty ";break;
                    case '6': str = "Sixty ";break;
                    case '7': str = "Seventy " ;break;
                    case '8': str = "Eighty " ;break;
                    case '9': str = "Ninety " ;break;
            }
            else if(i == num.length() - 2 && num.charAt(i) == '1'){
                switch(num.substring(i,i + 2)){
                    case "10": str = "Ten ";break;
                    case "11": str = "Eleven ";break;
                    case "12": str = "Twelve ";break;
                    case "13": str = "Thirteen ";break;
                    case "14": str = "Fourteen ";break;
                    case "15": str = "Fifteen ";break;
                    case "16": str = "Sixteen ";break;
                    case "17": str = "Seventeen ";break;
                    case "18": str = "Eighteen ";break;
                    case "19": str = "Nineteen ";break;
                }
            }
            ans = str + ans;
        }
            return ans;
    }
    public String numberToWords(int num) {
        String str = Integer.toString(num);
        String res = "";
        int layer = 0;
        for(int i = str.length(); i > 0; i -= 3){
            if(i < 0)
                break;
            String digits = "";
            if(i -3 < 0)
                digits = numberInHundred(str.substring(0, i));
            else
                digits = numberInHundred(str.substring(i - 3, i));
            if(layer == 1 && !digits.equals(""))
                digits += "Thousand ";
            else if(layer == 2 && !digits.equals(""))
                digits += "Million ";
            else if(layer == 3 && !digits.equals(""))
                digits += "Billion ";
            res = digits + res;
            layer += 1;
        }
        return res.trim();
    }
}
