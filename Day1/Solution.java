package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day1/input.txt"));
        boolean[] contains = new boolean[2020];
        while(scan.hasNextLine()){
            int nextNum = Integer.parseInt(scan.nextLine());
            if(contains[2020 - nextNum]) {
                System.out.println("Part 1: " + nextNum * (2020 - nextNum));
                break;
            }
            contains[nextNum] = true;
        }
        part2:
        for(int i = 0; i < 2020; i++){
            for(int j = i + 1; j < 2020 - i + 1; j++){
                if(contains[i] && contains[j] && contains[2020 - i - j]){
                    System.out.println("Part 2: " + i * j * (2020 - i - j));
                    break part2;
                }
            }
        }
    }
}