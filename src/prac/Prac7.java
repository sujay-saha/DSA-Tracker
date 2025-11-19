package prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prac7 {
    //Intuit
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        list2.add("cc");
        list2.add("dd");
        list2.add("aa");

        list1.addAll(list2);
        list1.stream()
                .filter(str->str.equals("aa"))
                .forEach(System.out::println);


    }
}
