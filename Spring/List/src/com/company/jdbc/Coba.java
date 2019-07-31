package com.company.jdbc;
import java.util.Scanner;
import java.util.Stack;
public class Coba {

    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan input  :");
        input = in.nextLine();

        if (checkBalancedParentesis(input)=="valid"){
            System.out.println("valid");
        }else {
            System.out.println("Not Valid");
        }
    }
    public static String checkBalancedParentesis(String expr)
    {
        if (expr == null){
            return "Not Valid";
        }
        else {
            if (expr.isEmpty())
                return "valid";

            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < expr.length(); i++) {
                char current = expr.charAt(i);
                if (current == '{' || current == '(' || current == '[') {
                    stack.push(current);
                }
                if (current == '}' || current == ')' || current == ']') {
                    if (stack.isEmpty())
                        return "Not valid";
                    char last = stack.peek();
                    if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                        stack.pop();
                    else
                        return "Not valid";

                }
            }
            return stack.isEmpty() ? "valid" : "Not valid";
        }
    }
}
