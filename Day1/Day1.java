package Day1;

import java.util.*;
import java.io.*;


public class Day1 {
    public static void part1() throws FileNotFoundException{
        File file = new File("Day1\\input.txt");
        if(!file.isFile()){
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(file);
        int prev = input.nextInt();
        input.nextLine();
        int count = 0;
        while(input.hasNextLine()) {
            int next = input.nextInt();
            input.nextLine();
            if(prev<next){
                count++;
            }
            prev = next;
        }
        input.close();
        System.out.println("increase count " + count);
    }

    public static void part2() throws FileNotFoundException{
        File file = new File("Day1\\input.txt");
        if(!file.isFile()){
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(file);
        int count = 0;
        int[] window = new int[3];
        int windowPointer = 0;
        int prev = 0;
        int next = 0;
        while(input.hasNextLine()) {
            prev = window[0] + window[1] + window[2];
            window[windowPointer++%3] = input.nextInt();
            input.nextLine();
            next = window[0] + window[1] + window[2];
            if(windowPointer>3){
                if(next>prev){
                    count++;
                }
            }
        }
        input.close();
        System.out.println("part2 count " + count);
    }
    public static void main(String[] args) throws FileNotFoundException{
        part1();
        part2();
    }
}
