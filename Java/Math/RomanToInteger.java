/*
PROBLEM STATEMENT :

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].


Hint #1  
Problem is simpler to solve by working the string from back to front and using a map.


//------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION - 1 : (Using pre-processing : inefficient solution) -----> >30ms

class Solution {
    public int romanToInt(String s) {
        
        String str = s.replaceAll("IV", "IIII").replaceAll("IX", "VIIII").replaceAll("XL", "XXXX")
                        .replaceAll("XC", "LXXXX").replaceAll("CD", "CCCC").replaceAll("CM", "DCCCC");
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        
        for(int i=0; i<str.length(); i++){
            sum += (int) map.get(str.charAt(i));
        }
        
        return sum;
    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

//SOLUTION - 2 : (without using pre-processing i.e., without modifying the given string) ---> 15ms

class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if(i != s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -= (int) map.get(s.charAt(i));
            }
            else{
                sum += (int) map.get(s.charAt(i));
            }
        }
        
        return sum;
    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

//SOLUTION - 3 : (Using Switch case to map the given values inside a Helper function) --> 7ms

class Solution {
    public int romanToInt(String s) {
         
        int sum = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if(i != s.length()-1 && getSymbolValue(s.charAt(i)) < getSymbolValue(s.charAt(i+1))){
                sum -= (int) getSymbolValue(s.charAt(i));
            }
            else{
                sum += (int) getSymbolValue(s.charAt(i));
            }
        }
        
        return sum;
    }
    
    public int getSymbolValue(char c){
        
        switch(c){
            case 'I' :
                return 1;
            
            case 'V' :
                return 5;
                
            case 'X' :
                return 10;
                
            case 'L' :
                return 50;
              
            case 'C' :
                return 100;
              
            case 'D' :
                return 500;
              
            case 'M' :
                return 1000;
        }
        
        return 0;
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------


//SOLUTION - 4 : (Using Swtich Case) ----> (efficient - 3ms)

class Solution {
    public int romanToInt(String s) {
         
        int sum = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            
            switch(s.charAt(i)){
                    
                case 'I' :
                    sum += (sum >= 5 ? -1 : 1);
                    break;
                    
                case 'V' :
                    sum += 5;
                    break;
                    
                case 'X' :
                    sum += 10 * (sum >= 50 ? -1 : 1);
                    break;
                    
                case 'L' :
                    sum += 50;
                    break;
                    
                case 'C' :
                    sum += 100 * (sum >= 500 ? -1 : 1);
                    break;
                    
                case 'D' :
                    sum += 500;
                    break;
                    
                case 'M' :
                    sum += 1000;
                    break;
            }
        }
        
        return sum;
    }
}
