package com.lin.TopInterviewLeet;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public  static void main(String[] args){
        String  s = "bbbbbbbbkhl";
        System.out.println(longestSubString(s));
    }

    public static int longestSubString(String s){
        int length=0;
        Set<Character> set= new HashSet<>();
        int l=0, r=0;
        while(r<s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            else {
                set.remove(s.charAt(l));
                l++;
            }
            length=Math.max(length, r-l);
        }
        return length;
    }
}
