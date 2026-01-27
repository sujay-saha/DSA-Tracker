package daily;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        mergeOverlap(new int[][]{{6, 8}, {1, 9}, {2, 4}, {4, 7}});
    }

    public static ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr,(int[] v1, int[] v2)->v1[0]-v2[0]);//to get all the intervals if present side by side

        for(int i =0;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(!result.isEmpty() && end<=result.get(result.size()-1)[1])
            {
                continue;
            }
            for(int j =i+1;j<n;j++){
                if(arr[j][0]<=end){
                    end = Math.max(arr[j][1],end);
                }else{
                    break;
                }
            }
            result.add(new int[]{start,end});
        }
        return result;
    }
}
