package prac;

import java.util.*;
import java.util.stream.Collectors;

public class Prac6 {

    public static void main(String[] args) {
        /*given a string : abcabcbb

        longest substring without repeating characters

        then answer will be abc , with the length of 3*/

        String input = "pwwekwe";
        System.out.println(longestSubstringWithoutRepeatingCharacter(input));
    }

    static String longestSubstringWithoutRepeatingCharacter(String input){
        char[] inputChar = input.toCharArray();
        int maxLengthOfSubstring =-1;
        String maxSubstring="";
        Map<Character,Integer> charCheck = new HashMap<>();

        //abcabcbb      pwwekwe
        for(int i =0;i<inputChar.length;i++){
            if(charCheck.containsKey(inputChar[i])){
                int prevIndex = charCheck.get(inputChar[i]);//0
                int currentSubLength = (i-prevIndex-1);//3
                if( currentSubLength >maxLengthOfSubstring ){
                    maxSubstring = maxSubstring.substring(prevIndex+1);
                    maxLengthOfSubstring =currentSubLength;
                }
                charCheck.put(inputChar[i],i);
            }else{ //abcabcbb //ml3 //abc
                charCheck.put(inputChar[i],i);
                maxLengthOfSubstring++;
                maxSubstring+=inputChar[i];
            }

        }
        return maxSubstring;
    }

}
