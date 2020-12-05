package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day5/input.txt"));
        int answer1 = 0;
        int answer2 = 0;
        ArrayList<Integer> seats = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            int column = 0;
            int row = 0;
            int toAdd = 64;
            for(char c : line.toCharArray()){
                if(c == 'F'){
                    toAdd /= 2;
                }
                if(c == 'B'){
                    row += toAdd;
                    toAdd /= 2;
                }
            }
            switch(line.substring(7)){
                case "LLL":
                column = 0;
                break;
                case "LLR":
                column = 1;
                break;
                case "LRL":
                column = 2;
                break;
                case "LRR":
                column = 3;
                break;
                case "RLL":
                column = 4;
                break;
                case "RLR":
                column = 5;
                break;
                case "RRL":
                column = 6;
                break;
                case "RRR":
                column = 7;
                break;
            }
            int id = 8 * row + column;
            if(id > answer1) answer1 = id;
            seats.add(id);
        }
        for(int i : seats){
            if(seats.contains(i + 2) && !seats.contains(i + 1)) answer2 = i + 1;
        }
        System.out.println("Part 1: " + answer1);
        System.out.println("Part 2: " + answer2);
    }
}
