package com.rgu.memorygame;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Utils {

    public static Integer[] getRandomList(int n, int max) {
        Random rng = new Random();
        Set<Integer> generated = new LinkedHashSet<Integer>();
        while (generated.size() < n) {
            Integer next = rng.nextInt(max) + 1;
            generated.add(next);
        }

        ArrayList<Integer> list = new ArrayList<>(generated);
        list.addAll(list);

        Integer[] solutionArray = new Integer[list.size()];
        list.toArray(solutionArray);

        for (int i = solutionArray.length - 1; i > 0; i--) {
            int index = rng.nextInt(i + 1);
            // Simple swap
            int a = solutionArray[index];
            solutionArray[index] = solutionArray[i];
            solutionArray[i] = a;
        }

        return solutionArray;
    }
}
