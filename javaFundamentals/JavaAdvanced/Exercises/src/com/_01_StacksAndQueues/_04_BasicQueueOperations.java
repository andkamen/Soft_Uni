package com._01_StacksAndQueues;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        Integer addCount = scan.nextInt();
        Integer removeCount = scan.nextInt();
        Integer searchFor = scan.nextInt();
        scan.nextLine();


        for (int i = 0; i < addCount; i++) {
            queue.add(scan.nextInt());
        }

        for (int i = 0; i < removeCount; i++) {
            queue.remove();
        }

        if (queue.contains(searchFor)) {
            System.out.println("true");
        } else if (queue.size()==0) {
            System.out.println(0);
        } else {
            int smallest = Integer.MAX_VALUE;
            for (int i = 0; i < addCount - removeCount; i++) {
                int num = queue.poll();
                if (num < smallest) {
                    smallest = num;
                }
            }
            System.out.println(smallest);

        }
    }
}
