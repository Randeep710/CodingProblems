/*
PROBLEM STATEMENT:

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION:

//1. Using sorting: ie Convert the strings into char arrays and sort the char arrays using Arrays.sort() method.
// then compare each character in both the arrays, if all matches, then the given strings are anagram of each other.

class Solution {
    public boolean isAnagram(String s, String t) {
      
        //Check whether both strings are of same length?
        //if not they are not ANAGRAM, so return false
        if(s.length() != t.length()){
            return false;
        }
        
        //covert both the strings into char[] arrays
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        //Sort both the char[] arrays
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        for(int i=0; i<sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return false;
            }
        }
        
        return true;
    }
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------


//2. Using single array (here, countArray) to count the characters.
// It is assumed that the characters are stored using 8 bit and there can be 256 possible characters.
// Let the two given strings be s and t.
// Create int[] countArray of size 256. By default each value inside countArray is 0.
// In a single loop iterate through the length of a string,
// and increment countArray[s.charAt(i) - 'a'] by 1
// and decrement countArray[t.charAt(i) - 'a'] by 1
// Then iterate through the countArray, if any value is != 0, then the strings are not ANAGRAM of each other, return FALSE, else return TRUE.

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        final int MAX_CHARS = 256;
        
        int[] countArray = new int[MAX_CHARS];
        
        // In a single loop iterate through the length of a string,
        // and increment countArray[s.charAt(i) - 'a'] by 1
        // and decrement countArray[t.charAt(i) - 'a'] by 1
        for(int i=0; i<s.length(); i++) {
            
            countArray[s.charAt(i) - 'a']++;    // i.e., countArray[s.charAt(i) - 'a'] = countArray[s.charAt(i) - 'a']+1;
            countArray[t.charAt(i) - 'a']--;    // i.e., countArray[t.charAt(i) - 'a'] = countArray[t.charAt(i) - 'a']+1;
        }
      
        /*
		        NOTE: (explaination)

		        Suppose given,
		        String 1, s = "spar"
		        and String 2, t = "rasp"
		        countArray[of size 256] = {0,0,0......0} -> (i.e., from index 0 to 255 all values are 0)

		        Now for i=0,
            countArray[s.charAt(i) - 'a']++ EQUALS TO :
            
		        countArray[s.charAt(i) - 'a'] = countArray[s.charAt(i) - 'a'] + 1
            countArray['s' - 'a']         = countArray['s' - 'a'] + 1 
		        countArray[115 - 97]          = countArray[115 - 97] + 1   ------> (here, ASCII value of 's' = 115 and ASCII value of 'a' = 97)
            countArray[18]                = countArray[18] + 1 
                                          = 0 + 1 
                                          = 1
                                          
            Similarly,
            countArray[t.charAt(i) - 'a']-- EQUALS TO :
            
            countArray[t.charAt(i) - 'a'] = countArray[t.charAt(i) - 'a'] - 1
            countArray['r' - 'a']         = countArray['r' - 'a'] - 1 
		        countArray[114 - 97]          = countArray[114 - 97] - 1   ------> (here, ASCII value of 'r' = 114 and ASCII value of 'a' = 97)
            countArray[17]                = countArray[17] - 1 
                                          = 0 - 1 
                                          = -1
            
            Now,
            countArray[17] = -1
            countArray[18] = 1
            and The entire countArray[of size 256] is something like = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,1,0,0,0,.............0}
            
            Try to build the countArray[] for the entire for() loop, in this manner...so that you can relate and understand.
		
	      */
      
      
        // For the given strings to be ANAGRAM, we need all the values inside countArray[] as 0.
        // Therefore, now iterate through the countArray,
        // if any value is != 0, then the strings are not ANAGRAM of each other, return FALSE, else return TRUE.
        for(int i : countArray) {
            
            if(i != 0) {
                return false;
            }
        }
        
        return true;
        
    }
}
