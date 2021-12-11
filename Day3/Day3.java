package Day3;

import java.io.*;
import java.util.*;

public class Day3 {
    public static void part1() throws FileNotFoundException{
        File file = new File("Day3\\input.txt");
        if(!file.isFile()){
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(file);
        int total = 0;
        int[] arr = new int[12];
        while(input.hasNextLine()){
            String bin = input.nextLine();
            for(int i = 0; i < bin.length(); i++){
                arr[i] += Integer.valueOf(Character.toString(bin.charAt(i)));
            }
            total++;
        }
        String most = "", least = "";
        for(int i = 0; i < arr.length; i++){
            int one = arr[i], zero = total-arr[i];
            System.out.println(one + " " + zero);
            if(one>zero){
                most += "1";
                least += "0";
            } else {
                most += "0";
                least += "1";
            }
        }
        input.close();
        System.out.println(Integer.valueOf(most, 2) + " " + Integer.valueOf(least, 2) + " " + total);

    }
    public static void main(String[] args) throws FileNotFoundException{
        part1();
    }
}
