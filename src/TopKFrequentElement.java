import java.util.*;

public class TopKFrequentElement {

    public static int[] topKFrequent(int[] nums, int k) {
        int []res=new int[k];
        Map<Integer,Integer> elementCount = new HashMap<>();
        for(int num:nums){
            elementCount.put(num, elementCount.getOrDefault(num,0)+1);
        }

        Map<Integer,Integer> orderedCount = new LinkedHashMap<>();
        elementCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->orderedCount.put(x.getKey(),x.getValue()));

        for(int i : orderedCount.keySet()){
            res[res.length-(k--)]=i;
            if(k==0){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(x->System.out.print(x+","));
    }
}
