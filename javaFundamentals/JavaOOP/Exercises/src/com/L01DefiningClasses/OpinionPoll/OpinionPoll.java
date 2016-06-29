package com.L01DefiningClasses.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeSet;

public class OpinionPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        TreeSet<Person> pollResults = new TreeSet<>((e1, e2) -> e1.name.compareTo(e2.name));

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            pollResults.add(new Person(input[0], Integer.valueOf(input[1])));
        }
        pollResults.stream().filter(person -> person.age > 30)
                .forEach(person1 -> System.out.printf("%s - %d%n", person1.name,person1.age));

    }
}
