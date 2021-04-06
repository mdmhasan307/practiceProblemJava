package com.lin.hankerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Example
 = "attack at dawn"  = "Attack at dawn"

The magazine has all the right words, but there is a case mismatch. The answer is .

Function Description

Complete the checkMagazine function in the editor below. It must print  if the note can be formed using the magazine, or .

checkMagazine has the following parameters:

string magazine[m]: the words in the magazine
string note[n]: the words in the ransom note
Prints

string: either  or , no return value is expected
Input Format

The first line contains two space-separated integers,  and , the numbers of words in the  and the , respectively.
The second line contains  space-separated strings, each .
The third line contains  space-separated strings, each .

Constraints

.
Each word consists of English alphabetic letters (i.e.,  to  and  to ).
Sample Input 0

6 4
give me one grand today night
give one grand today
Sample Output 0

Yes
Sample Input 1

6 5
two times three is not four
two times two is four
Sample Output 1

No
Explanation 1

'two' only occurs once in the magazine.

Sample Input 2

7 4
ive got a lovely bunch of coconuts
ive got some coconuts
Sample Output 2

No
Explanation 2

Harold's magazine is missing the word .
 */
public class RansomNote {

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new File("../Public/ransom.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ;//(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);
        if(m<1||m>3000||n<1||n>3000){
            System.out.println(" words number is out of range");
        }

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            if(magazineItem.length()<1||magazineItem.length()>5){
                System.out.println("word length is out of range");
                return;
            }
            magazine[i] = magazineItem;
            // System.out.print(" "+magazine[i]);
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       // System.out.println();
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            if(noteItem.length()<1||noteItem.length()>5){
                System.out.println("word length is out of range");
                return;
            }
            note[i] = noteItem;
           // System.out.print(" "+note[i]);
        }
       // System.out.println();

        checkMagazine(magazine, note);

        scanner.close();
    }


    static void checkMagazine(String[] magazine, String[] note) {


        Map<String,Integer> map= new HashMap<>();

        boolean replicate= true;
        for(String i: magazine){
            map.put(i, map.getOrDefault(i,0)+1);
        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()){
//            System.out.print(" "+entry.getValue());
//        }
        for(String i: note){
            map.put(i, map.getOrDefault(i,0)-1);
        }
//        System.out.println();
//        for (Map.Entry<String, Integer> entry : map.entrySet()){
//            System.out.print(" "+entry.getValue());
//        }

        System.out.println("\nAnswer: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()<0){
                replicate=false;
                break;
            }
        }
        //action.accept(entry.getKey(), entry.getValue());

        System.out.print(replicate? "Yes": "No");

    }



}



