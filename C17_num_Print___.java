package javaer.code;

/**17 打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 */

/**
 * 陷阱：n过大时是大数问题，不能简单用int或者long数据输出，需要采用字符串或者数组表达大数。
 *
 * 解决方法：通过字符数组char[]来进行输出数字。
 */

/** 方法二
 * 　1）采用递归将每一位都从0到9排列出来；
 *
 * 　　2）把字符串表达的数字打印出来
 */
public class C17_num_Print___ {

    static class Solution{
        //打印1到最大的n位数的主方法
        public void printToMaxOfDigits(int n){
            if(n <= 0){
                System.out.println("输入的n没有意义");
                return;
            }
            char number[] = new char[n];
            for (int i = 0; i < number.length; i++) {
                number[i] = '0';
            }
            for (int i = 0; i < 10; ++i) {
                number[0] = (char) (i + '0');
                printToMaxOfNDigitsRecursively(number, n, 0);
            }
        }
        //利用递归实现1到最大的n位数的全排列
        public void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
            if(index == n - 1){
                printNumber(number);
                return;
            }
            for (int i = 0; i < 10; ++i) {
                number[index + 1] = (char) (i + '0');
                printToMaxOfNDigitsRecursively(number, n, index + 1);
            }
        }

        //输出
        private void printNumber(char[] number) {
            boolean isBeginning0 = true;
            int nLength = number.length;
            for (int i = 0; i < nLength; ++i) {
                if(isBeginning0 && number[i]!='0'){
                    isBeginning0 = false;
                }
                if(!isBeginning0){
                    System.out.print(number[i]);
                }
            }
            System.out.println();
        }
    }

}

