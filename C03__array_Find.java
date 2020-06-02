package javaer.code;

/**二维数组中的查找
 *
 */
public class C03__array_Find {
    public class Solution{
        boolean Find(int[][] array,int num){
            boolean found = false;
            if (array.length==0 && array[0].length == 0) {
                return false;
            }
            int rows = array.length;
            int cols = array[0].length;
            if (rows > 0 & cols > 0) {
                int row = 0;
                int col = cols - 1;
                while (row < rows && col >= 0) {
                    if (array[row][col] == num) {
                        found = true;
                        break;
                    }else if(array[row][col]>num){
                        col--;
                    }else {
                        row++;
                    }
                }
            }
            return found;
        }
    }

}
