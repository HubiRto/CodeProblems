package org.example.two_sum;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;


        long start = System.nanoTime();
        int[] result = two_sum(nums, target);
        long end = System.nanoTime() - start;

        show(end, result);


        start = System.nanoTime();
        int[] result_2 = two_sum_2(nums, target);
        end = System.nanoTime() - start;

        show(end, result_2);
    }

    /**
     * Pierwsze rozwiązanie (Szybsze, Trudniejsze)
     *
     * @param nums   - Liczby, z których tworzymy liczbę
     * @param target - Liczba, którą chcemy uzyskać
     * @return - miejsca liczb w tablicy, z których można utworzyć liczbę docelową
     */
    public static int[] two_sum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * Drugie rozwiązanie (Wolniejsze, Prostsze)
     *
     * @param nums   - Liczby, z których tworzymy liczbę
     * @param target - Liczba, którą chcemy uzyskać
     * @return - miejsca liczb w tablicy, z których można utworzyć liczbę docelową
     */
    public static int[] two_sum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, (map.get(target - nums[i]))};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void show(long end, int[] result) {
        if(result == null) return;
        System.out.println("Czas wykonania w nanosekundach: " + end);
        System.out.println("Wynik: [" + result[0] + "," + result[1] + "]\n");
    }
}