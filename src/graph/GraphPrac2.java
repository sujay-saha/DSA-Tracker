package graph;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class GraphPrac2 {
    /*
    * Breadth-> Level wise traversal
    *
    * Starting node =1
    * Visited Array and a queue is mandate
    * Since it is one based and from 1->9 we create a visited arr of 10
    * */
    static ArrayList<Integer> bfsOfGraph(int V , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0]=true;
        while(!queue.isEmpty()){
            Integer val = queue.poll();
            bfs.add(val);

            for(Integer neighbour:adj.get(val)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }


    /*Recursion
    *
    * Print name 5 times
    * Print linearly from 1 to N
    * Print from N to 1
    * Print linearly from 1 to N(backtrack)
    * Print linearly from N to 1(backtrack)
    * */
    //Print name 5 times
    static void printTill5(int i){
        if(i==6){
            return;
        }
        System.out.println("name");
        printTill5(++i);
    }

    //Print linearly from 1 to N
    static void printTillN(int i, int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        printTillN(++i,n);
    }

    //Print from N to 1
    static void printNto1(int n, int i){
        if(n<i){
            return;
        }
        System.out.println(n);
        printNto1(--n,i);
    }

    //Print linearly from 1 to N
    static void printTillNBacktrack(int i, int n){
        if(n<1){
            return;
        }
        printTillNBacktrack(i,n-1);
        System.out.println(n);
    }

    //Print from N to 1 - Backtrack
    static void printNto1Backtrack(int i, int n){
        if(i>n){
            return;
        }
        printNto1Backtrack(i+1,n);
        System.out.println(i);
    }

    //Sum of first n numbers, ways : 1) Parameterized
    static void sumOfFirstNNumbers(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        sumOfFirstNNumbers(i-1,sum+i);
    }

    //Sum of first n numbers, ways : 2) Functional
    static int sumOfFirstNNumbers(int i){
        if(i<1){
            return 0;
        }
        return i+sumOfFirstNNumbers(i-1);
    }

    //Reverse an array
    static void reverseArray(int l,int r,int arr[]){
        if(l>=r){
           return;
        }

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverseArray(l+1,r-1,arr);
    }

    //Reverse an array-with one variable
    static void reverseArray(int i,int arr[]){
        int n=arr.length;
        if(i>=n/2){
            return;
        }

        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;

        reverseArray(i+1,arr);
    }

    //Palindrome or not
    static boolean isPalindrome(char[] str,int i){
        int n=str.length;
        if(i>=n/2){
            return true;
        }
        if(str[i]!=str[n-i-1]){
            return false;
        }


        return isPalindrome(str,i+1);
    }

    //Fibonacci- 0,1,1,2,3,5,8...
    static int fibonacciSeries(int n){
        if(n<=1){
            return n;
        }
        return fibonacciSeries(n-1)+fibonacciSeries(n-2);
    }

    //Print all Subsequences
    /* [3,1,2] ={3,1,2,31,12,32,312}

        0 X 0     0 means take and X means not take
        - - -
        3   2

        0 0 X
        - - -
        3 1

        0 0 0
        - - -
        3 1 2

        X X X
        - - -
        {empty}


[3,1,2]
 0 1 2
    * */

    static int arr[]={3,1,2};

    static void subsequenceOfArr(int index, ArrayList<Integer> list){
        int n =arr.length;
        if(index>=n){
            list.stream().forEach(System.out::print);
            System.out.println();
            return;
        }
        list.add(arr[index]);
        subsequenceOfArr(index+1,list);//take
        list.remove(list.indexOf(arr[index]));
        subsequenceOfArr(index+1,list);//not take
    }
    //Print subsequence whose sum is K
    static int arr2[]={1,2,1},k=2;
    static void subsequenceWhoseSumIsK(int index, ArrayList<Integer> list,int sum){
        int n =arr2.length;
        if(index>=n){
            if(sum==k){
                list.forEach(System.out::print);
                System.out.println();
            }
            return;
        }
        list.add(arr2[index]);
        subsequenceWhoseSumIsK(index+1,list,sum+arr2[index]);
        list.remove(list.indexOf(arr2[index]));
        subsequenceWhoseSumIsK(index+1,list,sum);
    }

    static int arr3[]={1,2,1},j=2;
    static boolean subsequenceWhoseSumIsKReturnOne(int index, ArrayList<Integer> list,int sum){
        int n =arr3.length;
        if(index>=n){
            if(sum==j){
                list.forEach(System.out::print);
                System.out.println();
                return true;
            }
            return false;

        }
        list.add(arr3[index]);
        if(subsequenceWhoseSumIsKReturnOne(index+1,list,sum+arr3[index])){
            return true;
        }
        list.remove(list.indexOf(arr3[index]));
        return subsequenceWhoseSumIsKReturnOne(index+1,list,sum);
    }


    //DFS
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {

        boolean vis[]=new boolean[adj.size()];
        ArrayList<Integer> dfs = new ArrayList<>();

        dfs(0,vis,dfs,adj);
        return dfs;

    }
    public void dfs(int node, boolean vis[],ArrayList<Integer> dfs,ArrayList<ArrayList<Integer>> adj) {
        vis[node]=true;
        dfs.add(node);

        for(Integer neighbour : adj.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour,vis,dfs,adj);
            }
        }
    }

    public static void main(String[] args) {
        //printTill5(1);
        //printTillN(1,100);
        //printNto1(5,1);

        //printTillNBacktrack(1,100);
        //printNto1Backtrack(1,50);

        //sumOfFirstNNumbers(3,0);
        //System.out.println(sumOfFirstNNumbers(3));
        /*int arr[]={1,2,3,4,5,6,7};
        reverseArray(0,arr.length-1,arr);
        Arrays.stream(arr).forEach(System.out::println);*/
        /*
        reverseArray(0,arr);
        Arrays.stream(arr).forEach(System.out::println);*/

        /*
        String s="ABA";
        char[] chArr = s.toCharArray();
        System.out.println(isPalindrome(chArr,0));
        */

        //System.out.println(fibonacciSeries(5));

        //subsequenceOfArr(0, new ArrayList<>());
        //subsequenceWhoseSumIsK(0, new ArrayList<>(),0);
        subsequenceWhoseSumIsKReturnOne(0, new ArrayList<>(),0);

        //dfsOfGraph();
        //bfsOfGraph();
    }
}
