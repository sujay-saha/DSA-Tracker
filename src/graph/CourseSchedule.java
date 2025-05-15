package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> taskOrder = new ArrayList<>();
        int inDegree[]= new int[n];

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int prerequisite[] : prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }

        for(int i =0; i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            taskOrder.add(0,node);

            for(int adjNode : adj.get(node)){
                --inDegree[adjNode];
                if(inDegree[adjNode]==0){
                    queue.add(adjNode);
                }
            }

        }
        return taskOrder;
    }
}
