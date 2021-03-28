package com.lin.CodinGame;

/*
Calculate Lucky Number between two numbers l and h included;
Lucky Number: number containing number 6 or 8 but not both.
output: number of lucky number between l and h
Constraints:
//0<l,h>2^20 (say)
 */

import java.util.HashSet;
import java.util.Set;

public class MThreeTest {

    public static void main(String[] args){
        int l=67;
        int h=68;
        System.out.println(countLuckyNumber(l,h));
    }

    public static int countLuckyNumber(int l , int h){
        int count=0;

        Set<Integer> set = new HashSet<>();
        int digit;

        for(int i=l;i<=h;i++) {
            int num=i;
            while (num >0) {
                digit = num % 10;
                if (digit == 6 || digit == 8) {
                    set.add(digit);
                }
                num = num/10;
            }
            if (set.size() == 1) {
                count++;
            }
            set.clear();

        }


        return count;
    }
}
