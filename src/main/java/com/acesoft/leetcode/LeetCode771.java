package com.acesoft.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 *  https://leetcode.com/problems/jewels-and-stones
 *
 *  You're given strings J representing the types of stones that are jewels, and S representing the
 *  stones you have. Each character in S is a type of stone you have.
 *
 *  You want to know how many of the stones you have are also jewels.
 *
 *  The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are
 *  case sensitive, so "a" is considered a different type of stone from "A".
 *
 *  Example 1:
 *  Input: J = "aA", S = "aAAbbbb"
 *  Output: 3
 *
 *  Example 2:
 *  Input: J = "z", S = "ZZ"
 *  Output: 0
 *
 *  Note:
 *  S and J will consist of letters and have length at most 50.
 *  The characters in J are distinct.
 */
public class LeetCode771 {

	/* Naive solution but very fast */
	public int numJewelsInStones(String J, String S) {
		if (J == null || S == null || J.length() == 0 || S.length() == 0) {
			return 0;
		}
		int sum = 0, i;
		for (i = 0; i < S.length(); i++) {
			if (J.indexOf(S.charAt(i)) > -1) {
				sum++;
			}
		}
		return sum;
	}

	/*
	 * Solution using Set; useful when number of Jewels are large to have fast
	 * lookup
	 */
	public int numJewelsInStones1(String J, String S) {
		if (J == null || S == null || J.length() == 0 || S.length() == 0) {
			return 0;
		}
		int sum = 0, i;
		Set<Character> jewels = new HashSet<>();
		for (i = 0; i < J.length(); i++) {
			jewels.add(J.charAt(i));
		}
		for (i = 0; i < S.length(); i++) {
			if (jewels.contains(S.charAt(i))) {
				sum++;
			}
		}
		return sum;
	}

	/* Solution storing Jewels as int of ASCII characters */
	public int numJewelsInStones2(String J, String S) {
		if (J == null || S == null || J.length() == 0 || S.length() == 0) {
			return 0;
		}
		int sum = 0, i;
		int[] ascii = new int[123];
		for (i = 0; i < J.length(); i++) {
			ascii[J.charAt(i)] = 1;
		}
		for (i = 0; i < S.length(); i++) {
			sum += ascii[S.charAt(i)];
		}
		return sum;
	}
}