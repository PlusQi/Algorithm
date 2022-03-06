package com.example.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*6-2";

        // 创建两个栈,一个存放数字,一个存放运算符
        calStack numStack = new calStack(10);
        calStack operStack = new calStack(10);

        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描的到的char保存到ch

        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (!operStack.isOper(ch)) { // 如果运算符
                // 判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    // 如果符号栈有操作符，就进行比较，如果当前的操作符优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数
                    // 再从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 把运算的结果入数栈
                        numStack.push(ch);
                    } else {
                        // 如果当前操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果为空直接入栈

                }
            }
        }

    }
}

class calStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组
    private int top = -1; // top表示栈顶，初始化为-1

    public calStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }

        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }

        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 返回当前栈顶的值
     * @return
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 遍历栈
     */
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，数字越大则优先级就越高
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是运算符
     * @param val 运算符
     * @return
     */
    public boolean isOper(char val) {
        return val == '+'
        || val == '-'
        || val == '*'
        || val == '/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }
}