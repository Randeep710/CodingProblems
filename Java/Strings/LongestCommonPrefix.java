/*
PROBLEM STATEMENT:

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION:

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        //Sort the given array -> strs
        //This will sort the strings present inside strs array in alphabetic order
        Arrays.sort(strs);
        
        int minLength = Math.min(strs[0].length(), strs[strs.length-1].length());
        
        int i=0;
        
        while(i < minLength && strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
            i++;
        }
        
        String lcp = strs[0].substring(0, i);
        return lcp;
    }
}
