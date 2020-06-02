package javaer.code;

import java.util.regex.Pattern;

public class Task {
    public static void main(String args[]) {
        String content ="I am noob" + "from runnoob.com";
        String pattern =".*runnoob.*";
        boolean isMatch = Pattern.matches(pattern,content);
        System.out.println("结果"+isMatch);
    }


}
