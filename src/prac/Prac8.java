package prac;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Prac8 {
//Encora
    /*large trade-1gb
            tradeid, traderid,amt, timestamp

    n traders total top traded amount
            n=input*/
//inmemory

    public static void main(String[] args) throws IOException {
        topNTraders(10);
    }
    static Map<Integer,Float> topNTraders(int n) throws IOException {

        try(BufferedReader fs = new BufferedReader(new FileReader("hello.csv"),1000))
        {
            String line = "1,2,20,timestamp";

            String[] token = line.split(",");
            int id = Integer.parseInt(token[0]);
            int traderId= Integer.parseInt(token[1]);
            float amount = Float.parseFloat(token[2]);
            Date timestamp= new Date(token[3]);


            Map<Integer,Float> mapOfTrades =new HashMap<>();
            Map<Integer,Float> topTraders =new HashMap<>();

                mapOfTrades.put(traderId,mapOfTrades.getOrDefault(traderId,amount)+amount);


            /*topTraders = mapOfTrades.entrySet().stream()
                    .sorted((e1,e2)->{return e2.getValue()-e1.getValue();})
                    .limit(n);*/
            return topTraders;

        }

    }
}
