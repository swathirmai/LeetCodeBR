package LeetCodeBR;

/*LeetCode : 12. Integer to Roman - Medium
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.

Example :

Input: num = 3
Output: "III"
 */

public class IntegerToRoman {

	private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
	private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public static void main(String[] args) {
		int num = 3;
		System.out.println(integerToRoman2(num));
	}

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		// Loop through each symbol, stopping if num becomes 0.
		for (int i = 0; i < values.length && num > 0; i++) {
			// Repeat while the current symbol still fits into num.
			System.out.println("values[i] :" + values[i]);
			while (values[i] <= num) {
				num -= values[i];
				System.out.println("num :" + num);
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}

	public static final String integerToRoman2(int number) {

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (number >= values[i]) {
				number -= values[i];
				s.append(symbols[i]);
			}
		}
		return s.toString();
	}
}


