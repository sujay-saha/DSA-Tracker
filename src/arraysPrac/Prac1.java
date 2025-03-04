package arraysPrac;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Prac1 {

    public static void leftRotateArray(){

        //Brute traverse and add one element to the end and shift rest of the array

        //Better we can reduce number of rotations by calculating %

        //Best
    }
    //
    public static int[] sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1,i=0;
        while(mid <= high){
            if(nums[i]==0){
                int temp =  nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                ++low;
                ++mid;
                ++i;
            }else if(nums[i]==1){
                ++mid;
                ++i;
            }else{
                int temp =  nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                --high;
            }
        }
        return nums;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> anagramsMap = new HashMap<>();
        for(String str:strs){
            int count[] = new int[26];

            for(char c: str.toCharArray()){
                ++count[c-'a'];
            }

            StringBuilder sb = new StringBuilder();
            for(int val : count){
                sb.append(val);
                sb.append("#");
            }
            String key = sb.toString();
            if(!anagramsMap.containsKey(key)){
                anagramsMap.put(key,new ArrayList<String>());
            }
            anagramsMap.get(key).add(str);
        }
        return new ArrayList(anagramsMap.values());
    }

    public static void main(String[] args) {
        /*Left Rotate the array by one place*/

        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0})));

        List<List<String>> groupAnagrams =groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(Arrays.toString(groupAnagrams.toArray()));
        /*int arr[] ={1,2,3,4,5};//54321
        int rotations=3;
        int actualToRotate = rotations%arr.length;
//        start->rotations
        int slide[]= new int[actualToRotate],start[]= new int [(arr.length)-actualToRotate];
        for(int i = 0;i<actualToRotate;i++){
            slide[i] = arr[i];
            if((i+actualToRotate)<arr.length)
                start[i] = arr[i+actualToRotate];
        }
//        for()
        Arrays.stream(start).forEach(System.out::print);
        System.out.println();
        Arrays.stream(slide).forEach(System.out::print);
        //for(int i = 0; i<actualToRotate)*/


    }
}
