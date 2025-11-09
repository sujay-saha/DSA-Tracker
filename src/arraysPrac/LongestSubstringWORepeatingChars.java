package arraysPrac;

import java.util.Arrays;

public class LongestSubstringWORepeatingChars {
    static int longestSubstring(String input){
        int n= input.length();
        int l=0,r=0;
        //Set<Character> charSet= new HashSet<>();
        int arr[]=new int[256];
        Arrays.fill(arr,-1);
        int maxLength=0;
        char chArr[] = input.toCharArray();
        while(r<n){
            if(arr[chArr[r]]!=-1){
                l = arr[chArr[r]] + 1;
            }
            arr[chArr[r]]=r;
            maxLength=Math.max((r-l+1),maxLength);
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input="abcabcbb";
        longestSubstring(input);
    }
}
