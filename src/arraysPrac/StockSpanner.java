package arraysPrac;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
        int maxPrice= Integer.MIN_VALUE;

        List<Integer> stocksTillToday;
        public StockSpanner() {
            stocksTillToday = new ArrayList<>();

        }

        public int next(int price) {
            stocksTillToday.add(price);
            int n = stocksTillToday.size();
            int count=0;
            for(int i=n-1;i>=0;i--){
                int stockPrev = stocksTillToday.get(i);
                if(price>=stockPrev){
                    ++count;
                    continue;
                }else{break;}
            }
            return count;
        }


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
