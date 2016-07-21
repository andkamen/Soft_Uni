package com.L01DefiningClasses.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> departmentSalary = new HashMap<>();
        HashMap<String, TreeSet<Employee>> departmentData = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] parameters = reader.readLine().split("\\s+");
            String name = parameters[0];
            double salary = Double.valueOf(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];

            Employee employee = new Employee(name, salary, position, department);

            if (parameters.length > 4) {
                if (isNumber(parameters[4])) {
                    employee.setAge(Integer.valueOf(parameters[4]));
                } else {
                    employee.setEmail(parameters[4]);
                }
            }
            if (parameters.length > 5) {
                if (isNumber(parameters[5])) {
                    employee.setAge(Integer.valueOf(parameters[5]));
                } else {
                    employee.setEmail(parameters[5]);
                }
            }

            if (!departmentData.containsKey(department)){
                departmentData.put(department,new TreeSet<>());
                departmentSalary.put(department,0.0);
            }
            departmentData.get(department).add(employee);
            departmentSalary.replace(department,departmentSalary.get(department)+salary);
        }

        Map.Entry<String,TreeSet<Employee>> highestSalaryDep = departmentData
                .entrySet()
                .stream()
                .sorted((d1, d2) -> Double.compare(departmentSalary.get(d2.getKey()),departmentSalary.get(d1.getKey())))
                .findFirst()
                .get();

        System.out.printf("Highest Average Salary: %s%n",highestSalaryDep.getKey());
        for (Employee employee : highestSalaryDep.getValue()) {
            System.out.println(employee);
        }
    }

    private static boolean isNumber(String argument) {
        try {
            Integer.valueOf(argument);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
