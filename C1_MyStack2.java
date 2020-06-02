package javaer.code;

import java.util.Stack;


// 压入时稍费空间，弹出稍省时间
public class C1_MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public C1_MyStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin =new Stack<Integer>();
    }

    //存储最小值的push方法
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum<=this.getmin()){
            this.stackMin.push(newNum);
        }else{
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value =this.stackData.pop();
        if(value == this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    //获取栈顶元素
    private int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
}
