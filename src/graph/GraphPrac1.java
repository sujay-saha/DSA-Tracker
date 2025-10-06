package graph;

import java.util.ArrayList;

public class GraphPrac1 {
    //Graph Representation
    //1.Input
    //Undirected
    /*
    n(nodes)=5, m(edges)=6
    input will be given for all edges like
    12
    13
    34
    24
    25
    45
    2. Adjacency matrix
    fill remaining with 0's
        0 1 2 3 4 5
    0
    1       1 1
    2     1     1 1
    3     1     1
    4       1 1   1
    5       1   1

Space : O(nxn)
Not used widely, only used when graph is small

 */
    void createGraph_AdjacencyMatrix(){
        int n=3,m=3;

        int adj[][]=new int[n+1][n+1];

        //edge 1--2
        adj[1][2]=1;
        adj[2][1]=1;

        //edge 2--3
        adj[2][3]=1;
        adj[3][1]=1;

        //edge 1--3
        adj[1][3]=1;
        adj[3][1]=1;

    }

    //3. Adjacency List
    static void createGraph_AdjacencyList(){
        int n=3,m=3;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        //n+1
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        //edge 1--2
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        //edge 2--3
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        //edge 1--3
        adjList.get(1).add(3);
        adjList.get(3).add(1);

        /*
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        Space Complexity: O(2m)
        */
        String separator="";
        for(int i=1;i<=n;i++){
            separator="--";
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j)+separator);
                separator="";
            }
            System.out.println();
        }

    }

    //3.1. Adjacency List -- Weighted Graph


    public static void main(String[] args) {
        createGraph_AdjacencyList();
    }
}
