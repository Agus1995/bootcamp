package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan input  :");
        input = in.nextLine();

        if (checkParentesis(input)){
            System.out.println("valid");
        }else {
            System.out.println("Not Valid");
        }
    }

    public static boolean checkParentesis(String str) {
        if (str.isEmpty())
            return true;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            }

            if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty())
                    return false;

                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
