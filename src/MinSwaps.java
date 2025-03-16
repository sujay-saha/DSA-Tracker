public class MinSwaps {
    //https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/description/
    public static int minimumSwap(String s1, String s2) {
        int xy=0,yx=0,count=0,n=s1.length();
        for(int i =0;i<n;i++){
            if(s1.charAt(i)=='x' && s2.charAt(i)=='y')
            {
                xy++;
            }
            else if(s1.charAt(i)=='y' && s2.charAt(i)=='x'){
                yx++;
            }
        }

        if((yx+xy)%2!=0){
            return -1;
        }else{
            count =((xy/2)+(yx/2)+(xy%2)*2);
            return count;
        }
    }
    public static void main(String[] args) {
        System.out.println("Minimum Swaps Required:"+minimumSwap("xy","yx"));
        System.out.println("Minimum Swaps Required:"+minimumSwap("yx","yx"));

    }


}
