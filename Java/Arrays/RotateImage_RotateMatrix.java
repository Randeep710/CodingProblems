/*
PROBLEM STATEMENT :

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Example 3:

Input: matrix = [[1]]
Output: [[1]]
Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]
 

Constraints:

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

//----------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

//SOLUTION - 1 : (Transposing the given matrix and Using a helper function to reverse the row elements of the transposed matrix)

class Solution {
    public void rotate(int[][] matrix) {
        
        //tanspose matrix
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                
                //diagonal elements 00, 11, 22 etc will remain same
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
                
            }
        }
        
        //reversing the row elements in transposed matrix
        for(int i=0; i<matrix.length; i++){
            reverseArray(matrix[i], 0, matrix[i].length-1);
        }
    }
    
    //method to reverse an array
    public void reverseArray(int[] arr, int start, int end){
        
        while(start < end){
            
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] =  temp;
            start++;
            end--;
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

//SOLUTION - 2 : (Transposing the given matrix and Reversing the row elements of the transposed matrix without using a helper function)

class Solution {
    public void rotate(int[][] matrix) {
        
        //tanspose matrix
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                
                //diagonal elements [0][0], [1][1], [2][2] etc will remain same
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
                
            }
        }
        
        //reversing the row elements in transposed matrix
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-1-j];
                matrix[i][matrix[i].length-1-j] = temp;
            }
        }
    }
}
