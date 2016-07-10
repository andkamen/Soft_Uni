package com.L03StaticMembers.ShapesVolume;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }

            switch (input[0]){
                case "Cube":
                    System.out.printf("%.3f%n",VolumeCalculator.calcCubeVolume(
                            new Cube(Double.valueOf(input[1]))));
                    break;
                case "Cylinder":
                    System.out.printf("%.3f%n",VolumeCalculator.calcCylinderVolume(
                            new Cylinder(Double.valueOf(input[1]),Double.valueOf(input[2]))));
                    break;
                case "TrianglePrism":
                    System.out.printf("%.3f%n",VolumeCalculator.calcTriangularPrismVolume(
                            new TriangularPrism(Double.valueOf(input[1]),Double.valueOf(input[2]),Double.valueOf(input[3]))));
                    break;
            }
        }
    }
}
