package stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {

    }

    List<Long> stack;
    long min = Long.MAX_VALUE;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(long val) {
        if(stack.isEmpty()){
            min=val;
            stack.add(val);
        }else{
            if(val>min){
                stack.add(val);
            }
            else{
                long newValue = (2*val-min);
                stack.add(newValue);
                min=val;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int top = stack.size()-1;
        long val = stack.get(top);
        if(val<min){
            min = (2*min)-val;
        }
        stack.remove(top);
    }

    public long top() {
        int top = stack.size()-1;
        long val = stack.get(top);
        if(val<min){
            return min;
        }
        return val;
    }

    public long getMin() {
        return min;
    }
}
