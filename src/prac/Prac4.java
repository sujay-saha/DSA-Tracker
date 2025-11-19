package prac;

import java.util.ArrayList;
import java.util.LinkedHashMap;

//LRU cache
// //Implement an LRU cache supporting O(1) get/put
//cache evict
public class Prac4 {
    //1,2,3   //4
    final int CACHE_MAX_SIZE = 3;
    LinkedHashMap<Integer,Integer> lruCache = new LinkedHashMap<>(CACHE_MAX_SIZE);
    /*     head
    [1]->[2]->[3]->  [4]
    ->[1]
    ->[2]
    ->[3]*/

    void put(Integer value){
        if(lruCache.size()==CACHE_MAX_SIZE){

            //move head -> head.next ;
            if(lruCache.containsKey(value)){
                //head or not
               /* if(not head){
                    prev = current.prev;
                    prev.next = current.next;
                }else{
                    head = head.next;
                }*/
            }
        }
            lruCache.put(value,value);

    }

    Integer get(int value ){
        Integer fetchValue= lruCache.get(value);
        if(fetchValue!=null){
            //new Pra4().put(fetchValue);
        }
        return fetchValue==null?-1:fetchValue;
    }

    /*void moveLruCacheElements(){
        for(int index =1;index<CACHE_MAX_SIZE;index++){
            lruCache.set
        }

    }*/




}
