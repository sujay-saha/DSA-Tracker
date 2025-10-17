package CodingQuesRandom;

class Stack{
    char arr[];
    int size;
    int top =-1;
    Stack(int size){
        this.size=size;
        arr=new char[size];
    }
    void push(char val){
        if(top<=arr.length) {
            arr[++top] = val;
        }
    }

    char pop(){
        if(!isEmpty()) {
            char val = arr[top];
            --top;
            return val;
        }
        return '#';
    }

    boolean isEmpty(){
        return top==-1;
    }

    boolean isFull(){
        return top==size;
    }

}

public class BalanceParanthesis {
    /*
    * Validate a custom expression
    * Given a string with {,}, and * ,where * can be { or } or empty
    * Validate if expression is balanced
    * */
    public static void main(String[] args) {
        String s="{}{}*";
        balanceParanthesis(s);
    }

    public static boolean balanceParanthesis(String str){
        Stack stack = new Stack(str.length());
        int starCounter=0;
        for(char c : str.toCharArray()){
            if(c=='{'){
                stack.push('{');
            }else if(c=='}'){
                stack.pop();
            }else{
                starCounter++;
            }

        }
        while(!stack.isEmpty()){
            char val = stack.pop();
            if(val =='{'){
                if(starCounter>0){
                    --starCounter;
                }
            }
            if(val == '#'){
                if(starCounter==0){
                    return true;
                }
                    return false;
            }
        }
        return false;
    }
}

