package Template;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day/input.txt"));
        int answer1 = 0;
        int answer2 = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
        }
        System.out.println("Part 1: " + answer1);
        System.out.println("Part 2: " + answer2);
    }
}
