/*
PROBLEM STATEMENT:

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 

Constraints:

1 <= n <= 30

HINT-1:
The following are the terms from n=1 to n=10 of the count-and-say sequence:
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
10.     13211311123113112211

HINT-2:
To generate the nth term, just count and say the n-1th term.

//----------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION:

class Solution {
    
    public String countAndSay(int n) {
        
        if(n == 1){
            
            return "1";
        }
        
        if(n == 2){
            
            return "11";
        }
        
        
        String str = "11" ;
            
        for(int i=3; i<=n; i++){
            
            char currentChar = str.charAt(0);
            int count = 1;
        
            StringBuilder sb = new StringBuilder(); 
            
            for(int j=1; j<str.length(); j++){ 
                
                char nextChar = str.charAt(j); 
                    
                if(currentChar != nextChar){
                    
                    sb.append(count); 
                    sb.append(currentChar);
                    
                    currentChar = nextChar; 
                    count =1;
                    
                }
                else{
                    
                    count++;
                }
              
            }//end of inner for loop
            
            sb.append(count);
            sb.append(currentChar);
            str = sb.toString();
          
        }//end of outer for loop
        
        return str;
    }
}
