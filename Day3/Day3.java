package Day3;

import java.io.*;
import java.util.*;

public class Day3 {
    public static class binaryTree{
        public int value;
        binaryTree left, right;
        binaryTree(){
            value = -1;
            left = null;
            right = null;
        }
        binaryTree(int v){
            value = v;
            left = null;
            right = null;
        }
        public boolean add(String s){
            binaryTree root = this;
            if(root.value != -1){
                return false;
            }
            for(char c: s.toCharArray()){
                int bit = c-48;
                if(bit == 0){
                    if(root.left != null){
                        root = root.left;
                    } else {
                        root.left = new binaryTree(0);
                        root = root.left;
                    }
                } else if(bit == 1){
                    if(root.right != null){
                        root = root.right;
                    } else {
                        root.right = new binaryTree(0);
                        root = root.right;
                    }
                }
                root.value++;
            }
            return true;
        }
        public static int total(binaryTree b){
            if(b == null){
                return 0;
            } else {
                return b.value;
            }
        }
    }
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
    public static void part2() throws FileNotFoundException{
        File file = new File("Day3\\input.txt");
        if(!file.isFile()){
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(file);
        binaryTree bt = new binaryTree();
        while(input.hasNextLine()){
            bt.add(input.nextLine());
        }
        input.close();
        binaryTree least = bt, most = bt;
        String leastNum = "", mostNum = "";
        while(least.right != null || least.left != null){
            if(least.left != null && least.right != null){
                if(binaryTree.total(least.left) <= binaryTree.total(least.right)){
                    leastNum+="0";
                    least = least.left;
                } else {
                    leastNum+="1";
                    least = least.right;
                }
            } else if(least.right == null){
                leastNum+="0";
                least = least.left;
            } else if(least.left == null){
                leastNum+="1";
                least = least.right;
            }
            if(least==null){
                break;
            }
        }
        while(most.right != null || most.left != null){
            if(most.right != null && most.left != null){
                if(binaryTree.total(most.right) >= binaryTree.total(most.left)){
                    mostNum+="1";
                    most = most.right;
                } else {
                    mostNum+="0";
                    most = most.left;
                }
            } else if(most.right == null){
                mostNum+="0";
                most = most.left;
            } else if(most.left == null){
                mostNum += "1";
                most = most.right;
            }
            if(most==null){
                break;
            }
        }
        System.out.println(Integer.valueOf(mostNum,2) + " " + Integer.valueOf(leastNum,2));
    }
    public static void main(String[] args) throws FileNotFoundException{
        //part1();
        part2();
    }
}
