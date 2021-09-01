/*
PROBLEM STATEMENT:

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION - 1:

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //This is done in order to make sure that,
        //map is made from the smaller of the two arrays
        if(nums1.length > nums2.length){
            
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i : nums2){
            int count = map.getOrDefault(i, 0);
            if(count > 0){
                list.add(i);
                map.put(i, count-1);
            }
        }
        
        int[] result = new int[list.size()];
        int j = 0;
        for(int i : list){
            result[j] = i;    //or we can combine assignment and increment in a single step as -> result[j++] = i; | after writing this, no need to write j++ in the next line.
            j++;
        }
        return result;
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------


//SOLUTION - 2:

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1); //1,1,2,2
        Arrays.sort(nums2); //2,2
        
        int i = 0;
        int j = 0;
        
        //to store repeatitions of similar elements from both the sorted arrays
        List<Integer> list = new ArrayList<Integer>();
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        
        int[] result = new int[list.size()];
        
        int k = 0;
        
        for(int num : list){
            result[k++] = num;        // this is equal to writing --> result[k] = num; k++;
        }
        
        return result;
    }
}
