package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day2/input.txt"));
        int part1Answer = 0;
        int part2Answer = 0;
        while(scan.hasNextLine()) {
            String[] parts = scan.nextLine().split(" ");
            int min = Integer.parseInt(parts[0].substring(0, parts[0].indexOf('-')));
            int max = Integer.parseInt(parts[0].substring(parts[0].indexOf('-') + 1));
            char letter = parts[1].charAt(0);
            String message = parts[2];
            int count = 0;
            for(char c : message.toCharArray()){
                if(letter == c) count++;
            }
            if(count <= max && count >= min) part1Answer++;
            if(message.charAt(min - 1) == letter ^ message.charAt(max - 1) == letter) part2Answer++;
        }
        System.out.println("Part 1: " + part1Answer);
        System.out.println("Part 2: " + part2Answer);
    }
}
