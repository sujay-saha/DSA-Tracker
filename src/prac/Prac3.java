/*
package prac;

public class Prac3 {
    import java.util.*;

    class Solution {

        public int solution(String s) {
            // write the solution here..
        }
    }

    class Main {

        public static void main(String[] args) {
            Scanner myObj = new Scanner(System.in);
            String line = myObj.nextLine();

            int ans = new Solution().solution(line);
            System.out.print(ans);
        }
    }

// Q1. The Rate Limiter: Sliding Window Log

// Implement a thread-safe SlidingWindowRateLimiter class. It should restrict requests for a given customerId based on a sliding time window.

// Your implementation must have:

// - A constructor: public SlidingWindowRateLimiter(int requestLimit, Duration timeWindow)

// - A method: public boolean isAllowed(String customerId)

// This method should return true if the number of requests from a specific customerId in the last timeWindow is less than the requestLimit. Each call to isAllowed counts as a request.

    */
/*1:count:0 =, timewin:60

     *//*

    class CustomerHitRecord{
        int requested;
        Duration firstHitTime;
        CustomerHitRecord(int requested, Duration firstHitTime){
            this.requested=requested;
            this.firstHitTime = firstHitTime;
        }

    }
    class SlidingWindowRateLimiter{
        public static final HIT_LIMIT= 10;
        Map<String,CustomerHitRecord> customerHitMap = new Hashmap<>();

        public SlidingWindowRateLimiter(int requestLimit, Duration timeWindow){
            this.requestLimit = requestLimit;
            this.timeWindow =timeWindow;
        }

        public boolean isAllowed(String customerId){
            if(customerHitMap.contains(customerId)){
                CustomerHitRecord hitRecord =customerHitMap.get(customerId);
                Time timeElapsed = Time.Now()-hitRecord.getFirstHitTime();

                int hits=hitRecord.getRequested();
                if(hits+1>HIT_LIMIT){
                    return false;
                }else{
                    hitRecord.setRequested(hits+1)
                    customerHitMap.put(hits+1);
                    return true;
                }
            }
        }

    }


    */
/*user
            userid,username,email,mob,role,type

    ratelimituser
            userid,firsttimehit,hits

    ratelimittype
            type,timelimit

*//*







}
*/
