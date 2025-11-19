package stack;

import java.util.ArrayList;

public class NextGreaterElement {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> resultList = new ArrayList<>();
        boolean flag = false;
        for(int i =0;i<n;i++){
            flag = false;
            for(int j =i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    resultList.add(arr[j]);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                resultList.add(-1);
            }
        }
        return resultList;
    }

}
