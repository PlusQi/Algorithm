package com.example.linkedList;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 入栈
        stack.add("1");
        stack.add("2");
        stack.add("3");

        // 出栈 3->2->1
        while (stack.size() > 0) {
            System.out.println(stack.pop()); // pop()就是将栈顶的数据取出
        }
    }
}
