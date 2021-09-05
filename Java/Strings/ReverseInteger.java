/*
PROBLEM STATEMENT:

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1

--------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION - 1 :

class Solution {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int num = x;
        
        while(num != 0){
            if(num < 0){
                sb.append("-");
                num *= -1;
            }
            
            int rem = num%10;
            sb.append(rem);
            num /= 10;
        }
        
        try{
            int result = Integer.parseInt(sb.toString());
            return result;
        }
        catch(Exception e){
            
            return 0;
        }
    }
}



//-------------------------------------------------------------------------------------------------------------------------------------------------


//SOLUTION - 2 :

class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x = -x;
        }
        
        int prev_reversedNumber = 0;
        int reversedNumber = 0;
        
        while(x != 0){
            int currentDigit = x%10;
            reversedNumber = reversedNumber*10 + currentDigit;
            
            if((reversedNumber - currentDigit)/10 != prev_reversedNumber){
                //if this condition satisfies, it means that it is a case of OVERFLOW, therefore we return 0
                return 0;
            }
            
            prev_reversedNumber = reversedNumber;
            x = x/10;
        }
        return (isNegative == true) ? -reversedNumber : reversedNumber;
    }
}
