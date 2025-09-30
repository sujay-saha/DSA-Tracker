package binarysearch;

public class SearchRotatedSortedArray {
    //Leetcode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length-1,mid;
        while(left <= right){
            mid =(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            //check which part is sorted
            if(nums[left]<=nums[mid])
            {
                if(nums[left]<= target && nums[mid]>=target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid]<= target && nums[right]>=target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
