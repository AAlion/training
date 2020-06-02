package javaer.code;


/** 16 整值的整数次方**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 2的n次方
 */
public class C16_num_Power {
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = power(base, exponent >> 1); //除2
        res *= res;
        if ((exponent & 1) == 1) { //为奇数，结果多×一次
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        double num1 = 2;
        int num2 = 7;
        double res = power(num1, num2);
    }
}
