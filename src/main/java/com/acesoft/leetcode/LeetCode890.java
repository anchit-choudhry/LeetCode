package com.acesoft.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/find-and-replace-pattern
 *
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
 * You may return the answer in any order.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing
 * every letter x in the pattern with p(x), we get the desired word.
 *
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to
 * another letter, and no two letters map to the same letter.
 *
 * Example 1:
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and
 * b map to the same letter.
 *
 * Example 2:
 * Input: words = ["a","b","c"], pattern = "a"
 * Output: ["a","b","c"]
 *
 * Constraints:
 * 1 <= pattern.length <= 20
 * 1 <= words.length <= 50
 * words[i].length == pattern.length
 * pattern and words[i] are lowercase English letters.
 */
public class LeetCode890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        boolean flag;
        char ch;
        int i, chAsInt, index;

        boolean[] visited = new boolean[26];
        int[] alphabets = new int[26];

        List<String> matches = new ArrayList<>();

        for (String word : words) {
            flag = true;
            Arrays.fill(alphabets, 0);
            Arrays.fill(visited, false);

            for (i = 0; i < word.length(); i++) {
                ch = word.charAt(i);
                chAsInt = ch - 'a';
                index = pattern.charAt(i) - 'a';

                if ((visited[chAsInt] && alphabets[index] != ch)
                        || (!visited[chAsInt] && alphabets[index] != 0)) {
                    flag = false;
                    break;
                } else {
                    if (alphabets[index] != 0) {
                        continue;
                    }
                    alphabets[index] = ch;
                    visited[chAsInt] = true;
                }
            }
            if (flag) {
                matches.add(word);
            }
        }
        return matches;
    }
}
