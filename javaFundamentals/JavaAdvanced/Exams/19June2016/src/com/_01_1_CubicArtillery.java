package com;

import sun.awt.image.ImageWatched;

import java.util.*;

public class _01_1_CubicArtillery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxCapacity = Integer.parseInt(scan.nextLine());
        LinkedHashMap<Character, Integer> bunkerData = new LinkedHashMap<>();

        List<Character> bunkerOrder = new ArrayList<>();
        int[] bunkerCurrentCapacity = new int[122];
        List<Queue> bunkers = new ArrayList<>();


        int currentBunker = 0;
        int currentWeapon = 0;

        while (true) {
            String[] input = scan.nextLine().trim().split("\\s+");

            if (input[0].equals("Bunker")) {
                break;
            }

            for (int i = 0; i < input.length; i++) {
                if (hasOnlyLetters(input[i])) {
                    bunkerData.put(input[i].charAt(0), 0);
                    bunkers.add(new ArrayDeque<Integer>());
                    bunkerOrder.add(input[i].charAt(0));
                } else if (bunkers.isEmpty()) {
                    continue;

                } else {
                    currentWeapon = Integer.parseInt(input[i]);

                    if (canFitInBunker(currentWeapon, maxCapacity)) {

                        if (hasRoomInBunker(currentWeapon, maxCapacity, bunkerData.get(bunkerOrder.get(currentBunker)))) {
                            bunkers.get(currentBunker).add(currentWeapon);
                            bunkerData.put(bunkerOrder.get(currentBunker), bunkerData.get(bunkerOrder.get(currentBunker) + currentWeapon));
                            continue;
                        }
                    }

                    currentBunker++;
                    for (int j = 0; j < bunkerData.size(); j++) {

                        currentBunker = (currentBunker + j) % (bunkerData.size());

                        if (canFitInBunker(currentWeapon, maxCapacity)) {

                            while (!hasRoomInBunker(currentWeapon, maxCapacity, bunkerData.get(bunkerOrder.get(currentBunker)))) {
                                bunkerData.put(bunkerOrder.get(currentBunker), bunkerData.get(bunkerOrder.get(currentBunker) + (int) bunkers.get(currentBunker).peek()));
                                bunkers.get(currentBunker).poll();
                            }
                            bunkers.get(currentBunker).add(currentWeapon);
                            bunkerData.put(bunkerOrder.get(currentBunker), bunkerData.get(bunkerOrder.get(currentBunker) + currentWeapon));
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < bunkers.size(); i++) {
            System.out.printf("%c -> %s%n", bunkerOrder.get(i), String.join(", ", bunkers.get(i).toString()).replace("[", "").replace("]", ""));
        }
    }

    public static boolean canFitInBunker(int currentWeapon, int bunkerMaxCapacity) {
        return currentWeapon <= bunkerMaxCapacity;
    }

    public static boolean hasRoomInBunker(int currentWeapon, int bunkerMaxCapacity, int bunkerCurrentCapacity) {
        return currentWeapon + bunkerCurrentCapacity <= bunkerMaxCapacity;
    }

    public static boolean hasOnlyLetters(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}

