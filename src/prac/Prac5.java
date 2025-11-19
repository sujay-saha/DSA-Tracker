package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prac5 {
/*Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

 IVVI

 */



    public static void main(String[] args) {
        Map<Character,Integer> romanToNumberMap = new HashMap<>();
        romanToNumberMap.put('I',1);
        romanToNumberMap.put('V',5);//check 5*10
        romanToNumberMap.put('X',10);
        romanToNumberMap.put('L',50);
        romanToNumberMap.put('C',100);
        romanToNumberMap.put('D',500);
        romanToNumberMap.put('M',1000);
        String value="XXIX";
        romanToNumber(value);
    }

    //keep track of small to big
    static Integer romanToNumber(String value){
        List stack = new ArrayList();
        for(char c:value.toCharArray()){

        }
        return -1;
    }
}

/*
* TicketingSystem
* General-10/km  - 2 hours valid -
* Senior - 5/km - 2 Hours valid
* Daypass - 200/day - 24 hours/ midnight
* 5 stations ABCDE -1,2,3,4
* #API few inputs                                        source destination
* o/p ticket obj-Type:
* Source Destination
* Distance b/w
* Final Price
*
*  #DS                                                         a-b
* */

/*Station
stationid

Graph 
/get
/metro/book?src=src&des=des*/
