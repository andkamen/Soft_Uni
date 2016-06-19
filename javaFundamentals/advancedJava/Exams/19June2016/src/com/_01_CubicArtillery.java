package com;

import java.util.*;

public class _01_CubicArtillery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> maxBunkerCapacity = new ArrayList<>();
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
                    bunkers.add(new ArrayDeque<Integer>());
                    maxBunkerCapacity.add((int) input[i].charAt(0));
                } else if (bunkers.isEmpty()) {
                    continue;

                } else {
                    currentWeapon = Integer.parseInt(input[i]);

                    if (canFitInBunker(currentWeapon, maxBunkerCapacity.get(currentBunker))) {

                        if (hasRoomInBunker(currentWeapon, maxBunkerCapacity.get(currentBunker), bunkerCurrentCapacity[maxBunkerCapacity.get(currentBunker)])) {
                            bunkers.get(currentBunker).add(currentWeapon);
                            bunkerCurrentCapacity[maxBunkerCapacity.get(currentBunker)] += currentWeapon;
                            continue;
                        }
                    }

                    currentBunker++;
                    for (int j = 0; j < maxBunkerCapacity.size(); j++) {

                        currentBunker = (currentBunker + j) % (maxBunkerCapacity.size());

                        if (canFitInBunker(currentWeapon, maxBunkerCapacity.get(currentBunker))) {

                            while (!hasRoomInBunker(currentWeapon, maxBunkerCapacity.get(currentBunker), bunkerCurrentCapacity[maxBunkerCapacity.get(currentBunker)])) {
                                bunkerCurrentCapacity[maxBunkerCapacity.get(currentBunker)] -= (int) bunkers.get(currentBunker).peek();
                                bunkers.get(currentBunker).poll();
                            }
                            bunkers.get(currentBunker).add(currentWeapon);
                            bunkerCurrentCapacity[maxBunkerCapacity.get(currentBunker)] += currentWeapon;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < bunkers.size(); i++) {
            System.out.printf("%c -> %s%n", maxBunkerCapacity.get(i), String.join(", ", bunkers.get(i).toString()).replace("[", "").replace("]", ""));
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
