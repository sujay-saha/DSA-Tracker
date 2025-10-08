package arraysPrac;

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {
        pascalTriangle(5);
    }

    static void pascalTriangle(int n){
        
        /*
        0:1
        1:11
        2:121

         */

        for(int i =0;i<n;i++){
            ArrayList<Integer> prevList= new ArrayList<>();
            ArrayList<Integer> currList= new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) {
                    prevList.add(1);
                }
                if(i>1){
                    for(Integer val:prevList)
                    {//currList.add();
                         }
                }



            }
            System.out.println();
        }
        
    }
}
