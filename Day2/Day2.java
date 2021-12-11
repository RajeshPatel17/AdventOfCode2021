package Day2;

import java.io.*;
import java.util.*;

public class Day2 {
    public static void part1() throws FileNotFoundException{
        File file = new File("Day2\\input.txt");
        if(!file.isFile()){
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(file);
        int horizontal = 0;
        int depth = 0;
        while(input.hasNextLine()){
            String action = input.next();
            int vector = input.nextInt();
            input.nextLine();
            switch(action){
                case "forward":
                    horizontal += vector;
                    break;
                case "down":
                    depth += vector;
                    break;
                case "up":
                    depth -= vector;
                    break;
            }
        }
        input.close();
        System.out.println("output1: " + horizontal*depth);
    }
    public static void part2() throws FileNotFoundException{
        File file = new File("Day2\\input.txt");
        if(!file.isFile()){
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(file);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        while(input.hasNextLine()){
            String action = input.next();
            int vector = input.nextInt();
            input.nextLine();
            switch(action){
                case "forward":
                    horizontal += vector;
                    depth += vector*aim;
                    break;
                case "down":
                    aim += vector;
                    break;
                case "up":
                    aim -= vector;
                    break;
            }
        }
        input.close();
        System.out.println("output1: " + horizontal*depth);
    }
    public static void main(String[] args) throws FileNotFoundException{
        part1();
        part2();
    }
}
