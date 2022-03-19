package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.apache.commons.text.RandomStringGenerator;

import com.acesoft.model.TTLObject;

/*
 *  Write a map where elements expire.
 *
 *  The insertion operation should take (key, value, time to expiry). When the get(key) operation
 *  occurs, it should return the key if the entry has not expired, else return null.
 *
 *  What does the memory usage look like of your solution? What strategies could you employ to
 *  guarantee that entries in the map will eventually be deleted?
 */
public final class TTLMapProblem {

    private static long now = 0L;

    private static Map<String, TTLObject> TTLMap = new HashMap<>();
    private static void initMap() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .build();
        for (int i = 1; i <= 100; i++) {
            TTLMap.put(generator.generate(1, i), new TTLObject(generator.generate(1, i),
                    ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE)));
        }
    }

    private static void insertElement(String key, String elem, long expiry) {
        TTLMap.remove(key);
        TTLMap.put(key, new TTLObject(elem, expiry));
    }

    public static void main(String[] args) {
        initMap();
        insertElement("abcd", "cdef", 12345);
        now = System.currentTimeMillis();
        retrieveMap();
        retriveElement("abcd");
    }

    private static void retrieveMap() {
        System.out.println(TTLMap.size());
        String results = TTLMap.entrySet().stream().filter(x -> x.getValue().getTimestamp() > now)
                .map(x -> x.getKey() + "#" + x.getValue().getValue())
                .collect(Collectors.joining("\n"));
        System.out.println(results);
        System.out.println(results.split("\n").length);
    }

    private static String retriveElement(String key) {
        TTLObject keyVal = TTLMap.get(key);
        return keyVal == null ? null : keyVal.getTimestamp() > now ? keyVal.getValue() : null;
    }

    private TTLMapProblem() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }
}