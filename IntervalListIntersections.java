//Interval List Intersections

//PROBLEM:
/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

*/

//SOLUTION:
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        List<int[]> intervals = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        
        int temp1 =0;
        int temp2 = 0;
        while(i < A.length && j < B.length)
        {
            int e1 = A[i][0];
            int s1 = A[i][1];
        
            int e2 = B[j][0];
            int s2 = B[j][1];
            
            if(e1 <= s2 && e2 <= s1)
            {
                temp1 = Math.max(e1,e2);
                temp2 = Math.min(s1,s2);
                intervals.add(new int[]{temp1, temp2});
            }
            
            if(A[i][1] > B[j][1])
                j++;
            else
                i++;
        }
        
        int[][] result = new int[intervals.size()][2];
        int index = 0;
        for (int[] interval : intervals) {
            result[index++] = interval;
        }

        return result;
    }
}
