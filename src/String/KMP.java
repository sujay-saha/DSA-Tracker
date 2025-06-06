package String;

public class KMP {
    static int[] createLPS( String pattern){

        int LPS[] = new int[pattern.length()], currLength=0,i =1;
        LPS[0]=0;
        while(i<LPS.length){
            if(pattern.charAt(i)==pattern.charAt(currLength)){
                ++currLength;
                LPS[i]=currLength;
                i++;
            }else{
                if(currLength==0){
                    LPS[i]=0;
                    i++;
                }else{
                    currLength=LPS[currLength-1];
                }
            }

        }
//        for(int j =0;j<LPS.length;j++){
//            System.out.print(LPS[j]+", ");
//        }
        return LPS;
    }

    static boolean patternMatchingKMP(String text, String pattern,int[] LPS){

        int i=0,j=0, M =text.length(), N = pattern.length();
        boolean patternFound= false;
        while(i<M){
            if(text.charAt(i)==pattern.charAt(j)){
                System.out.println(text.charAt(i)+","+i);
                i++;
                j++;
            }
            if(j==N){
                patternFound = true;
                System.out.println(i-j);//Index
                j=LPS[j-1];
            }else if(pattern.charAt(j)!=text.charAt(i)){
                if(j!=0) {
                    j = LPS[j - 1];
                }else{i++;}
            }
        }
        return patternFound;
    }

    public static void main(String[] args) {
        String text="geerggeek", pattern="geek";
        int[] LPS = createLPS(pattern);

        System.out.println(pattern+" is "+(patternMatchingKMP(text,pattern, LPS)?"FOUND":"NOT FOUND!")+" in "+text);
    }

}
