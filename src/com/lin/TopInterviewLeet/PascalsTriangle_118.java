package com.lin.TopInterviewLeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_118 {

    public static void main(String[] args){
        int n=6;
        System.out.println(generateRows(n));
    }

    public static List<List<Integer>> generateRows(int numRows){
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> row=new ArrayList<>();
        int n=0;
        while(n<numRows){
            row.add(0,1);
            for(int i=1;i<row.size()-1;i++){
                row.set(i, row.get(i)+row.get(i+1));
            }
            result.add(new ArrayList<>(row));
            n++;
        }
        return result;
    }
}
