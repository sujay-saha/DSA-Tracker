import java.util.ArrayList;
import java.util.List;

public class Recursion {

    static String reverseStr(String str) {
        if (str.length() == 1) {
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
        /*
         * h
         * e
         * l
         * l
         * o
         * */
    }

    static String reverseStr2(String str, int start, int end) {
        if (start >= end) {
            return str;
        }
        if (start == 0)
            str = str.charAt(end) + str.substring(start + 1, end) + str.charAt(start);
        else
            str = str.substring(0, start) + str.charAt(end) + str.substring(start + 1, end) + str.charAt(start) + str.substring(end + 1);
        System.out.println(str);
        return reverseStr2(str, start + 1, end - 1);
    }

    static int fibo(int n) {
        //2^n Time Complexity(Exponential Nature)
        if (n <= 1) {
            return n;
        }
        System.out.println(n);
        return fibo(n - 1) + fibo(n - 2);
    }

    static Integer[] arr = {3, 1, 2};
    static int n = arr.length;

    static void subsequence(int i, List<Integer> list) {

        if (i >= n) {
            for (Integer val : list) {
                System.out.print(val);
            }
            System.out.println();
            return;
        }
        list.add(arr[i]);
        subsequence(i + 1, list);
        list.remove(arr[i]);
        subsequence(i + 1, list);

    }

    static Integer[] arr3 = {1, 2, 1};
    static int n3 = arr3.length;

    //Printing subsequences whose sum is K
    static void sumSubsequence2(int i, List<Integer> list, int sum) {
        if (i >= n) {
            if (k == sum) {
                for (Integer val : list) {
                    System.out.print(val);
                }
                System.out.println();
            }
            return;
        }
        list.add(arr3[i]);
        sumSubsequence2(i + 1, list, sum + arr3[i]);
        list.remove(arr3[i]);
        sumSubsequence2(i + 1, list, sum);
    }

    static Integer[] arr2 = {1, 2, 1};
    static int n2 = arr2.length, k = 2;

    //Printing any subsequence whose sum is K#TECHNIQUE to print only one answer
    static boolean sumSubsequence(int i, List<Integer> list, int sum) {
        if (i == n) {
            if (k == sum) {
                for (Integer val : list) {
                    System.out.print(val);
                }
                return true;
            } else {
                return false;
            }
        }
        list.add(arr2[i]);
        if (sumSubsequence(i + 1, list, sum + arr2[i])) {
            return true;
        }
        list.remove(arr2[i]);
        if (sumSubsequence(i + 1, list, sum)) {
            return true;
        }
        return false;
    }

    //Printing any subsequence whose sum is K#Want only count of subsequences
    /*
     int f(){

        base case
            return 1 -> Condition satisfies
            return 0 -> Condition not  satisfies

            l = f()
            r = f()
            //------------------------------------
            #if n recursion calls are there do a
            for loop i->n and   [N Queen Prob]
                s+=f();
                return s;
           //------------------------------------
            return l+r;
     }
    */
    static int sumSubsequence3(int i,  int sum) {
        int l, r;
        //if array contains positives only
        if(sum>k){return 0;}
        if (i >= n) {
            if (k == sum) {
                return 1;
            }
            return 0;
        }
//        list.add(arr3[i]);
        l = sumSubsequence3(i + 1, sum + arr3[i]);
//        list.remove(arr3[i]);
        r = sumSubsequence3(i + 1, sum);
        return l + r;
    }

    public static void main(String[] args) {
        String str = "helloworld";
        //System.out.println(reverseStr(str));
        System.out.println("2:" + reverseStr2(str, 0, str.length() - 1));
        System.out.println("_______________________________________________");
        System.out.println(fibo(6));
        System.out.println("_______________________________________________");
        subsequence(0, new ArrayList<Integer>());
        System.out.println("_______________________________________________");
        sumSubsequence(0, new ArrayList<>(), 0);
        System.out.println("_______________________________________________");
        System.out.println("Count of subsequences:"+sumSubsequence3(0,  0));
    }

}
