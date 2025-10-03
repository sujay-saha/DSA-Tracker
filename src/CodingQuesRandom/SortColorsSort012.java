package CodingQuesRandom;

class SortColorsSort012{

    public static void sortColors(int[] nums) {
        //0-low-1[0] low-mid-1[1] mid-high-1[unsorted] high-n-1[2]
        int low=0, mid=0, high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,0,0,0,0,1,2,0,2,1,2,0,0,2};
        sortColors(nums);
    }
}