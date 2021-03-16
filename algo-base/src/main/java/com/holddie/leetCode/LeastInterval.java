package com.holddie.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeastInterval {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A'};
        System.out.println(leastInterval(tasks, 2));
    }
}
