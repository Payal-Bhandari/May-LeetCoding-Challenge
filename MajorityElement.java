//Majority Element

//PROBLEM
/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/

//SOLUTION:
class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
            {
                int count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }
        }
        
        int ans = 0;
        int value = (length/2) + 1;
         for(Map.Entry <Integer,Integer> entry: map.entrySet()){
            int compare = entry.getValue();
             int temp = 0;
             if(value <= compare)
                 ans = entry.getKey();
                
          }      
        
        return ans;
    }
}
