/*
PROBLEM STATEMENT:

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION:

//1. By comparing characters in the given string with each other using 2 FOR loops to traverse the given string.

class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        for(int i=0; i<s.length(); i++){
            boolean isUnique = true;
            
            for(int j=0; j<s.length(); j++){
                if(i != j && s.charAt(i) == s.charAt(j)){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique){
                index = i;
                break;
            }
        }
        return index;
    }
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------


// 2. By using a LinkedHashMap to store the characters of the given string as KEYS and their occurrences as VALUES in the map.

class Solution{
  
  public int firstUniqChar(String s) {
    
    int index = -1;
    
    //We use a LinkedHashMap so that every entry <keys,value> in the map maintains their order of insertion.
    //Which will help us to fetch the first non repeating character.
    //KEY = each character in the given string s
    //VALUE = number of occurrences of each character
    
    Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    
    for(int i=0; i<s.length(); i++) {
      
      Character ch = s.charAt(i);
      
      if(map.containsKey(ch)) {
        map.put(ch, map.get(ch)+1);
      } 
      else {
        map.put(ch, 1);
      }
    }
    
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      if(entry.getValue == 1) {
        Character firstNonReapeatingCharacter = entry.getKey();
        for(int i=0; i<s.length(); i++) {
          if(s.charAt(i) == firstNonReapeatingCharacter) {
            //index = i;
            //return index;
            
            //or we can directly return i:
            return i;
          }
        }
      }
    }
    return index;
  }
}
