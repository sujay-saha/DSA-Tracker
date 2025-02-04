public class AddBinary {
    /*Link: https://leetcode.com/problems/add-binary/description/
    *
    * Example 1:

        Input: a = "11", b = "1"
        Output: "100"
        Example 2:

        Input: a = "1010", b = "1011"
        Output: "10101"
      */

    public static String removeInitialZeroes(String str) {
        int startIndex = str.indexOf("1");

        if (startIndex > 0) {
            str = str.substring(startIndex);
        } else if (startIndex == -1) {
            return "";
        }

        return str;
    }

    public static String addBinary(String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        String str1 = removeInitialZeroes(str3);
        String str2 = removeInitialZeroes(str4);

        int lenStr1 = str1.length() - 1;
        int lenStr2 = str2.length() - 1;
        int carry = 0;

        while (lenStr1 >= 0 || lenStr2 >= 0) {
            int sum = carry;
            if (lenStr1 >= 0) {
                sum += str1.charAt(lenStr1) - '0';
            }
            if (lenStr2 >= 0) {
                sum += str2.charAt(lenStr2) - '0';
            }
            sb.insert(0,sum % 2);
            carry = sum / 2;
            lenStr1--;
            lenStr2--;
        }

        if(carry!=0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("ADD BINARY->" + addBinary("111", "0110"));
    }
}
