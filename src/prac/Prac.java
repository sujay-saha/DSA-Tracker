package prac;

/**
 * Question
 *
 * Given a sorted array arr[] and a number x, write a function that counts the
 * occurrences of x in arr[]. Expected time complexity is O(Logn) 
 *
 * Example:  
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
 * Output: 4 // x (or 2) occurs 4 times in arr[]
 *
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
 * Output: 1 
 *
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
 * Output: 2 
 *
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
 * Output: -1 // 4 doesn&#39;t occur in arr[]
 */


public class Prac {

    static int occurenceOfX(int arr[], int x){
        int firstOccurence = findFirstOccurence(arr,x);
        int lastOccurence = findLastOccurence(arr,x);

        if(firstOccurence!=-1 && lastOccurence!=-1){

            return (lastOccurence-firstOccurence)+1;
        }
        return -1;
    }

    static int findFirstOccurence(int arr[],int x){
        int left = 0, right =arr.length-1,mid;
        int result=-1;
        while(left<=right){
            mid = (left+right)/2;

            if(arr[mid]==x){
                result = mid;
                right=mid-1;
                continue;
            }
            if(arr[mid]>x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    static int findLastOccurence(int arr[], int x){
        int left = 0, right =arr.length-1,mid;
        int result = -1;
        while(left<=right){
            mid = (left+right)/2;

            if(arr[mid]==x){
                result = mid;
                left = mid+1;
                continue;
            }
            if(arr[mid]>x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1,1,1, 2, 2, 2, 2, 3,3,}, x = 4;

        System.out.println(occurenceOfX(arr, x));

    }
}
