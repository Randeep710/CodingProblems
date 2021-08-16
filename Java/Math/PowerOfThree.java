/*
PROBLEM STATEMENT:

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
Example 4:

Input: n = 45
Output: false
 

Constraints:
-231 <= n <= 231 - 1
 
Follow up: Could you solve it without loops/recursion?
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION:

class Solution {
    public boolean isPowerOfThree(int n) {
     
        double a = Math.log(n) / Math.log(3);
        return Math.abs(a - Math.round(a)) < 1e-10; //here, 1e-10 = 1 x (10)^(-10), i.e. 10 to the power of (-10) which equals to 0.0000000001
    }
}
