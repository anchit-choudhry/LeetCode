package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/find-the-town-judge
 *
 * In a town, there are n people labelled from 1 to n.  There is a rumor that one of these people is
 * secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a
 * trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.
 * Otherwise, return -1.
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 * Input: n = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 * Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 * Constraints:
 * 1 <= n <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= n
 */
public class LeetCode997 {

  public int findJudge(int n, int[][] trust) {
    int i;
    int[] nums = new int[n];
    for (int[] conn : trust) {
      nums[conn[1] - 1]++;
      nums[conn[0] - 1]--;
    }
    for (i = 0; i < n; i++) {
      if (nums[i] == n - 1) {
        return i + 1;
      }
    }
    return -1;
  }
}
