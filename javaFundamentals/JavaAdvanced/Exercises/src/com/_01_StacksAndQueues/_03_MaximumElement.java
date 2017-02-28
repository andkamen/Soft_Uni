package com._01_StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _03_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxElement = new Stack<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] numArr = reader.readLine().split(" ");
            int command = Integer.parseInt(numArr[0]);

            switch (command) {
                case 1:
                    stack.push(Integer.parseInt(numArr[1]));
                    if (maxElement.isEmpty()){
                        maxElement.push(Integer.parseInt(numArr[1]));
                    }
                    else if (maxElement.peek()<Integer.parseInt(numArr[1])){
                        maxElement.push(Integer.parseInt(numArr[1]));
                    }

                    break;
                case 2:
                    if(stack.peek()==maxElement.peek())
                    {
                        maxElement.pop();
                    }
                    stack.pop();
                    break;
                case 3:
                    System.out.println(maxElement.peek());
                    break;
            }
        }
    }
}
