package javaer.code;

import java.util.Stack;
//辅助栈实现一个顺序栈
public class C5_SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        sortStackByStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();

        while (!stack.isEmpty()){
            int cur = stack.pop();

            while(!help.isEmpty() && cur > help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        //??
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }

}
