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


    public static int[] topKFrequentPriorityQueue(int[] nums, int k) {
        int []res=new int[k];
        Map<Integer,Integer> elementCount = new HashMap<>();
        for(int num:nums){
            elementCount.put(num, elementCount.getOrDefault(num,0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((a,b)->elementCount.get(a)-elementCount.get(b));

        for(int key:elementCount.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        while(k-->0){
            res[k]=minHeap.remove();
        }

        return res;
    }

    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        //The indexes act as frequency for Bucket Sort
        int []res=new int[k];
        Map<Integer,Integer> elementCount = new HashMap<>();
        for(int num:nums){
            elementCount.put(num, elementCount.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int i = 0 ; i<nums.length+1;i++){
            buckets[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry : elementCount.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        for (int index = buckets.length-1;index>0 && k>0;index--){
            if(!buckets[index].isEmpty()){
                for(Integer val:buckets[index]) {
                    res[res.length - k--] = val;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(x->System.out.print(x+","));
        System.out.println("---");System.out.println("PriorityQueue:::");Arrays.stream(topKFrequentPriorityQueue(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(x->System.out.print(x+","));
        System.out.println("---");System.out.println("BucketSort:::");Arrays.stream(topKFrequentBucketSort(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(x->System.out.print(x+","));
    }
}
