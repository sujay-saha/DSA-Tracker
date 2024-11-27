public class StringReversalWithPreservingSpace {
    static String reversal(String input) {
        int i = 0, j = input.length() - 1;
        while (i < j) {

            if (input.charAt(i) != ' ') {
                input = input.substring(0, i) + input.charAt(j) + input.substring(i + 1, j) + input.charAt(i) + input.substring(j + 1);
                j--;
            }
            i++;

        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(reversal("I Am Not String"));
    }
}
