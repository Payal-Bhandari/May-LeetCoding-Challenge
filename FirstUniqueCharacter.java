//First Unique Character in a String

//PROBLEM:

 /*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

*/

//SOLUTION:
class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
         int ans = -1;
         if(s == "")
             return -1;
        for(int i = 0; i < s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
            {
                int count = map.get(s.charAt(i));
                count = count+1;
                map.put(s.charAt(i),count);
            }
        }
        
        
        for(int i = 0 ; i < s.length(); i++)
        {
            if(map.get(s.charAt(i)) == 1)
            {
                ans = i;
                break;
            }
                
        }
        
        return ans;
    }
}
