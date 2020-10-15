//Number Complement

// PROBLEM 
/*Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

*/

// SOLUTION:
class Solution {
    public int findComplement(int num) {
        
         String str=Integer.toBinaryString(num);
        char c[]=str.toCharArray();
      for(int i=0;i<c.length;i++)
      {
          if(c[i]=='1')
              c[i]='0';
          else if(c[i]=='0')
              c[i]='1';
      }
        String s=new String(c);
        return Integer.parseInt(s,2);
    }
    
}
