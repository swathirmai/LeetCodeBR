package LeetCodeBR;

/*Leetcode : 1010. Pairs of Songs With Total Durations Divisible by 60 - Medium
You are given a list of songs where the ith song has a duration of time[i] seconds.
Return the number of pairs of songs for which their total duration in seconds is divisible by 60. 
Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
Example :
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60*/

public class PairsOfSongs {

	public static void main(String[] args) {
		int[] time = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(time));

	}
	public static int numPairsDivisibleBy60(int[] time) {
		int count = 0, n = time.length;
		for (int i = 0; i < n; i++) {
			// j starts with i+1 so that i is always to the left of j
			// to avoid repetitive counting
			for (int j = i + 1; j < n; j++) {
				if ((time[i] + time[j]) % 60 == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
