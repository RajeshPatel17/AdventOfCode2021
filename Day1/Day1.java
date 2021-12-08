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

    public static void part2(){

    }
    public static void main(String[] args) throws FileNotFoundException{
        part1();

    }
}
