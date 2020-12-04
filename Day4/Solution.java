package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Day4/input.txt"));
        int answer1 = 0;
        int answer2 = 0;
        String pass = "";
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.contains("byr:") && pass.contains("byr:")
            || line.contains("iyr:") && pass.contains("iyr:")
            || line.contains("eyr:") && pass.contains("eyr:")
            || line.contains("hgt:") && pass.contains("hgt:")
            || line.contains("ecl:") && pass.contains("ecl:")
            || line.contains("hcl:") && pass.contains("hcl:")
            || line.contains("cid:") && pass.contains("cid:")) {
                while(line.length() != 0){
                    line = scan.nextLine();
                }
                pass = "";
                continue;
            }
            if(line.length() == 0){
                if(pass.contains("byr:") && pass.contains("iyr:") && pass.contains("eyr:") && pass.contains("hgt:") && pass.contains("ecl:") && pass.contains("hcl:") && pass.contains("pid:")) {
                    answer1++;
                    String[] items = pass.split(" ");
                    boolean isValid = true;
                    for(String item : items){
                        String data = item.substring(item.indexOf(':') + 1);
                        switch(item.substring(0, item.indexOf(':'))){
                            case "byr":
                            if(data.length() != 4) isValid = false;
                            if(Integer.parseInt(data) < 1920 || Integer.parseInt(data) > 2002) isValid = false;
                            break;
                            case "iyr":
                            if(data.length() != 4) isValid = false;
                            if(Integer.parseInt(data) < 2010 || Integer.parseInt(data) > 2020) isValid = false;
                            break;
                            case "eyr":
                            if(data.length() != 4) isValid = false;
                            if(Integer.parseInt(data) < 2020 || Integer.parseInt(data) > 2030) isValid = false;
                            break;
                            case "hgt":
                            if(data.indexOf('c') == -1){
                                if(data.indexOf('i') == -1){
                                    isValid = false;
                                } else {
                                    int height = Integer.parseInt(data.substring(0, data.indexOf('i')));
                                    if(height < 59 || height > 76 || !data.substring(data.indexOf('i')).equals("in")) isValid = false;
                                }
                            } else {
                                int height = Integer.parseInt(data.substring(0, data.indexOf('c')));
                                if(height < 150 || height > 193 || !data.substring(data.indexOf('c')).equals("cm")) isValid = false;
                            }
                            break;
                            case "hcl":
                            if(data.charAt(0) != '#') isValid = false;
                            for(char c : data.substring(1).toCharArray()){
                                if(!((c >= 48 && c <= 57) || (c >= 97 && c <= 122))) isValid = false;
                            }
                            break;
                            case "ecl":
                            if(!(data.equals("amb") || data.equals("blu") || data.equals("brn") || data.equals("gry") || data.equals("grn") || data.equals("hzl") || data.equals("oth"))) isValid = false;
                            break;
                            case "pid":
                            if(data.length() != 9) isValid = false;
                            for(char c : data.toCharArray()){
                                if(c < 48 || c > 57) isValid = false;
                            }
                            break;
                        }
                    }
                    if(isValid) answer2++;
                }
                pass = "";
                continue;
            } else {
                pass += line + " ";
            }
        }
        System.out.println("Part 1: " + answer1);
        System.out.println("Part 2: " + answer2);
    }
}
