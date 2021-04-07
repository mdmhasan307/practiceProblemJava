package com.lin.hankerrank;
/*
An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:

A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.

Example



The hiker first enters a valley  units deep. Then they climb out and up onto a mountain  units high. Finally, the hiker returns to sea level and ends the hike.

Function Description

Complete the countingValleys function in the editor below.

countingValleys has the following parameter(s):

int steps: the number of steps on the hike
string path: a string describing the path
Returns

int: the number of valleys traversed
Input Format

The first line contains an integer , the number of steps in the hike.
The second line contains a single string , of  characters that describe the path.

Constraints

Sample Input

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, the hike can be drawn as:

_/\      _
   \    /
    \/\/
The hiker enters and leaves one valley.

 */

import java.io.*;
import java.util.Scanner;

public class CountingValley {

    private static Scanner scanner;
    static {
        try {
            scanner = new Scanner(new File("../Public/valley.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("../Public/OUTPUT_PATH"));
        int steps = scanner.nextInt();
        if(steps<2||steps>1000000){
            System.out.println("Too many steps");
        }
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String paths = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int result = countingValleys(steps, paths);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();


    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleyNum=0;
        int count=0;

        for(int i=0;i<steps;i++){
            if(path.charAt(i)!='U'|| path.charAt(i)!='D'){
                System.out.println("Invalid character");
                break;
            }
            if(path.charAt(i)=='U'){
                count++;
            }
            else if( path.charAt(i)=='D'){
                count--;
            }

            if(path.charAt(i)=='U'&& count==0){
                valleyNum++;
            }

        }
        return valleyNum;

    }

}






