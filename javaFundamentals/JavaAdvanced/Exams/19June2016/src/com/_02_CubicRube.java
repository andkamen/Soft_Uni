package com;

import java.util.Scanner;

public class _02_CubicRube {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long[][][] cube = new long[n][n][n];
        boolean[][][] cubeHit = new boolean[n][n][n];


        while (true) {
            String[] input = scan.nextLine().trim().split("\\s+");

            if (input[0].equals("Analyze")) {
                break;
            }
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            long num = Integer.parseInt(input[3]);

            if (num == 0) {
                continue;
            }

            if (!areCoordinatesValid(x, y, z, n)) {
                // System.out.println("invalid");
                continue;
            }
            if (!cubeHit[x][y][z]) {
                cube[x][y][z] += num;
                cubeHit[x][y][z] = true;
            }
        }
        long result = 0;
        int notHitCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result += cube[i][j][k];
                    if (cube[i][j][k] == 0) {
                        notHitCount++;
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(notHitCount);
    }

    private static boolean areCoordinatesValid(int x, int y, int z, int n) {
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= n) {
            return false;
        }
        if (z < 0 || z >= n) {
            return false;
        }
        return true;
    }
}
