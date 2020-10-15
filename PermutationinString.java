//Permutation in String

//PROBLEM:
/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.


Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
*/

//SOLUTION:
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] letters = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
        }
        
        
        int j = 0;
        int rem = s1.length();
        boolean ans = false;
        
        for(int  i = 0 ; i < s2.length();i++){
            while(j < s2.length() && j-i < s1.length())
            {
                if(letters[s2.charAt(j++) - 'a']-- > 0) {
                    rem--;
                }
            }
            if(rem == 0 && j - i == s1.length()) 
                ans = true;
            if(letters[s2.charAt(i) - 'a']++ >= 0)
                rem++;
        }
        return ans;
    }
}
