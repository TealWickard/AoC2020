package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day3/input.txt"));
        int answer1 = 0;
        BigInteger answer2 = new BigInteger("1");
        char[][] items = new char[323][];
        int curr = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            items[curr] = line.toCharArray();
            curr++;
        }
        int x = 0;
        int y = 0;
        x+=3;
        y++;
        while(y < 323){
            if(items[y][x] == '#')answer1++;
            x += 3;
            if(x >= items[0].length) x -= items[0].length;
            y++;
        }
        int[] slopes = new int[5];
        slopes[1] = answer1;
        x = 0;
        y = 0;
        x+=1;
        y++;
        while(y < 323){
            if(items[y][x] == '#')slopes[0]++;
            x += 1;
            if(x >= items[0].length) x -= items[0].length;
            y++;
        }
        x = 0;
        y = 0;
        x+=5;
        y++;
        while(y < 323){
            if(items[y][x] == '#')slopes[2]++;
            x += 5;
            if(x >= items[0].length) x -= items[0].length;
            y++;
        }
        x = 0;
        y = 0;
        x+=7;
        y++;
        while(y < 323){
            if(items[y][x] == '#')slopes[3]++;
            x += 7;
            if(x >= items[0].length) x -= items[0].length;
            y++;
        }
        x = 0;
        y = 0;
        x+=1;
        y+=2;
        while(y < 323){
            if(items[y][x] == '#')slopes[4]++;
            x += 1;
            if(x >= items[0].length) x -= items[0].length;
            y+=2;
        }
        for(int i : slopes){
            answer2 = answer2.multiply(new BigInteger(Integer.toString(i)));
        }
        System.out.println("Part 1: " + answer1);
        System.out.println("Part 2: " + answer2);
    }
}
