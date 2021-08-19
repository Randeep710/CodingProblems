/*
PROBLEM STATEMENT:

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION:

//1. Using String Builder

class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        StringBuilder sb = new StringBuilder("str");
        
        String reversedStr = sb.reverse().toString();
      
        //Compare str and reversedStr,
        //if equal then the given string is a PALINDROME, return TRUE, else return FALSE
        if(str.equals(reversedStr)){
          return true;
        }
      
        return false;
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

//2. Using ArrayList and Character class built in methods
// like Character.isLetter(Character c) and Character.isDigit(Character c) to filter the given string
// and put the characters inside and arraylist of characters.
// Check whether first and last character, 2nd and 2nd last character, etc.(respective similar checks) in the arraylist are equal to each other or not.
// If any character check is FALSE, the the given string is NOT a PALINDROME, return FALSE
// Else return TRUE, which indicates that the given string is a PALIDROME.

class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();
        
        List<Character> charList = new ArrayList<Character>();
      
        //to keep count of how many characters from the original given string are actually accepted in the charList
        int count = 0;
        
        for(int i=0; i<str.length(); i++) {
            
            if(!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i))) {
                continue;
            }
            else {
                charList.add(str.charAt(i));
                count++;
            }
        }
        
        int i = 0;
        int j = count - 1;
        
        while(i<j) {
            if(charList.get(i) != charList.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
