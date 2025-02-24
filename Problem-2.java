// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int n = matrix.length;
        for(int i = n-2; i >= 0; i--)
        {
            for(int j = 0;j<n;j++)
            {
                if(j==0)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j == n-1)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        for(int j = 0; j < n;j++)
        {
            minimum = Math.min(minimum,matrix[0][j]);
        }
        return minimum;
    }
}