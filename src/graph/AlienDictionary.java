package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

        public String topoSort(List<List<Integer>> adj, int []inDegree, int distinctChars){
            String result="";
            Queue<Integer> queue = new LinkedList<>();

            for(int i =0;i<adj.size();i++){
                if(inDegree[i]==0){
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                int node = queue.poll();
                result+=(char)(node+(int)'a');

                for(int adjNode:adj.get(node)){
                    --inDegree[adjNode];
                    if(inDegree[adjNode]==0){
                        queue.add(adjNode);
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (inDegree[i] != 0 && inDegree[i] != -1) {
                    return "";
                }
            }
            return result;

        }
        public String findOrder(String[] words) {
            // code here
            List<List<Integer>> adj = new ArrayList<>();
            int []inDegree = new int[26];
            int distinctChars = 0;
            for(int i =0;i<26;i++){
                adj.add(new ArrayList<>());
                inDegree[i]=-1;
            }

            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    if(inDegree[ch-'a']==-1){

                        inDegree[ch-'a']=0;
                        ++distinctChars;
                    }
                }
            }
            boolean inFlag =false;
            for(int i =0;i<words.length-1;i++){
                String s1 = words[i];
                String s2 = words[i+1];
                int len = Math.min(s1.length(),s2.length());
                for(int j =0;j<len;j++){
                    int u = s1.charAt(j)-'a';
                    int v = s2.charAt(j)-'a';
                    if(u!=v){
                        inFlag=true;
                        ++inDegree[v];
                        adj.get(u).add(v);
                        break;
                    }
                }
                if(!inFlag && s1.length()>s2.length()){
                    return "";
                }
            }
            return topoSort(adj,inDegree,distinctChars);
        }

}
