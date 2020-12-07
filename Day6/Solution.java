package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argz) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day6/input.txt"));
        int answer1 = 0;
        int answer2 = 0;
        boolean[] bools = new boolean[26];
        ArrayList<String> answers = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            // String[] args = line.split(" ");
            // String[] args = line.split(",");
            if(line.length() == 0){
                int curr = 0;
                for(boolean b : bools){
                    if(b) answer1++;
                }
                for(int i = 97; i < 97 + 26; i++){
                    boolean doAdd = true;
                    for(String s : answers){
                        if(s.indexOf((char)i) == -1) doAdd = false;
                    }
                    if(doAdd)answer2++;
                }
                answers = new ArrayList<>();
                bools = new boolean[26];
            } else {
                answers.add(line);
                for(char c : line.toCharArray()){
                    if(!bools[c - 97]) bools[c - 97] = true;
                }
            }
        }
        System.out.println("Part 1: " + answer1);
        System.out.println("Part 2: " + answer2);
    }
}
