package com.lin.TopInterviewLeet;
/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
 */

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args){
        String s = "ba@c2baB2C@";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s){
      if (s.length()<1||s.length()>1000){
          return "";
      }
        int start=0, end=0;
        int length=0;
        for(int i=0;i<s.length();i++){
            int l1=expandAroundCenter(s,i,i);
            int l2=expandAroundCenter(s,i,i+1);
            length=Math.max(l1,l2);
            if(length>end-start){
                start=i-(length-1)/2;
                end=i+length/2;
            }

        }

        return s.substring(start, end+1);

    }

    private static int expandAroundCenter(String s, int l, int r){

        while(l>=0 && r<s.length()&& Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))
        && Character.isLetterOrDigit(s.charAt(l))&& Character.isLetterOrDigit(s.charAt(r))){
            l--;
            r++;
        }
        return r-l-1;
    }
}
