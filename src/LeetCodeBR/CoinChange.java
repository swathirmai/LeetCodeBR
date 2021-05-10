package LeetCodeBR;
import java.util.*;

/*LeetCode : 322. Coin Change - Medium
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin. 

Example:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1*/

public class CoinChange {

	public static void main(String[] args) {

		//		int[] currencies = {1,2,5};
		//		int amount = 11;
		//
		//		System.out.println("Number of ways we can pay using given currencies are : " + coinchange(0, amount, currencies, ""));

		int[] currencies = {1,2,5};
		int amount = 7;

		System.out.println(
				"Number of ways we can pay using given currencies are : " + 
						coinChangeNew(currencies, amount));
	}

	public static int coinChangeBFS(int[] coins, int amount) {
		if (amount == 0)
			return 0;

		LinkedList<Integer> amountQueue = new LinkedList<Integer>();
		LinkedList<Integer> stepQueue = new LinkedList<Integer>();

		// to get 0, 0 step is required
		amountQueue.offer(0);
		stepQueue.offer(0);

		while (amountQueue.size() > 0) {
			int temp = amountQueue.poll();
			int step = stepQueue.poll();

			if (temp == amount)
				return step;

			for (int coin : coins) {
				if (temp > amount) {
					continue;
				} else {
					if (!amountQueue.contains(temp + coin)) {
						amountQueue.offer(temp + coin);
						stepQueue.offer(step + 1);
					}
				}
			}
		}

		return -1;
	}

	public static int coinChangeNew(int[] denom, int amount) {
		List<Integer> result = new ArrayList<>();
		if (denom.length == 0 || amount == 0) {
			return 0;
		}
		for (int i = denom.length - 1; i >= 0; i--) {
			int d = denom[i];
			while (amount >= d) {
				amount -= d;
				result.add(d);
			}
		}
		return result.size();
	}

	private static Integer coinChange2(int[] coins, int target) {
		int max = target + 1;
		int dp[] = new int[max];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 0; i <= target; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		return dp[target] == max ? -1 : dp[target];

	}

	public static int coinchangeAllOptions(int ci, int remaining, int[] currencies,
			String paid) {
		if (remaining == 0) {
			/*
			 * this means the amount to be paid can be paid
			 *  using only the given currencies.
			 */
			System.out.println(paid);
			/*
			 * as this is one of the way to pay, hence it 
			 * will contribute +1 number of ways for itself
			 */
			return 1;
		}
		if (remaining < 0) {
			/*
			 * if the remaining amount to be paid is negative,
			 * this means that the set of coins we've paid does 
			 * not add upto the amount to be paid, hence it is 
			 * not one of the way to pay.
			 */
			return 0;
		}

		int res = 0;
		for (int i = ci; i < currencies.length; i++) {

			/*
			 * we must start our loop from current index, as 
			 * if we loop through all currencies once again 
			 * then there will be a repetition in the ways used 
			 * to pay the amount.
			 */
			res += coinchangeAllOptions(i, remaining - currencies[i], currencies, 
					paid + Integer.toString(currencies[i]) + ", ");

		}

		return res;

	}

	public static int coinChange(int[] coins, int amount) {
		return coinChange(0, coins, amount);
	}

	private static int coinChange(int idxCoin, int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (idxCoin < coins.length && amount > 0) {
			int maxVal = amount/coins[idxCoin];
			int minCost = Integer.MAX_VALUE;
			for (int x = 0; x <= maxVal; x++) {
				if (amount >= x * coins[idxCoin]) {
					int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
					if (res != -1)
						minCost = Math.min(minCost, res + x);
				}
			}
			return (minCost == Integer.MAX_VALUE)? -1: minCost;
		}
		return -1;
	}
}
