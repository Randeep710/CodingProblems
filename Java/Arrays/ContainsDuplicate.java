/*
PROBLEM STATEMENT:

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION - 1 : (using Map)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        
        for(int i : nums){
            if(map.containsKey(i)){
                return true;
            }
            else{
                map.put(i, 1);
            }
        }
        
        return false;
    }
}


//-----------------------------------------------------------------------------------------------------------------------------------------------


//SOLUTION - 2: (using HashSet instead of Map)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums){
            
            if(set.contains(i)){
                return true;
            }
            else{
                set.add(i);
            }
        }
        
        return false;
    }
}


//-----------------------------------------------------------------------------------------------------------------------------------------------------


//SOLUTION - 3: (Using HashSet and Comparing lengths at last)

//LOGIC :
// 1. Put nums[] array inside a HashSet.
// 2. And then, compare size of the HashSet and length of the nums[] array)
// 3. If Size of HashSet != Length of nums[] array, then containsDuplicate() returns TRUE
// 4. If Size of HashSet == Length of nums[] array, then containsDuplicate() returns FALSE


class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }
        
        if(set.size() != nums.length){
            return true;
        }
        
        return false;
    }
}
