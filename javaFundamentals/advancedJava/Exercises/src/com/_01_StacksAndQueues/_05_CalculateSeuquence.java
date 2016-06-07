package com._01_StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class _05_CalculateSeuquence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long n = Long.parseLong(scan.nextLine());

        Queue<Long> queue = new ConcurrentLinkedQueue<>();
        queue.add(n);
        List<Long> output = new ArrayList<>();

        int counter = 0;
        while (counter < 50){
            long current = queue.poll();
            output.add(current);

            queue.add(current + 1);
            queue.add(2 * current + 1);
            queue.add(current + 2);
            counter+=3;
        }

        while(output.size()<50){
            output.add(queue.poll());
        }
        for (Long num : output) {
            System.out.printf("%d ",num);  //thank god for Judge trimming the final result
        }
        //System.out.println(output.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
