package LeetCodeBR;

import java.util.Arrays;

/*LeetCode : 242. Valid Anagram - Easy
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example :
Input: s = "anagram", t = "nagaram"
Output: true*/

public class ValidAnagram {

	public static void main(String[] args) {
		String str1 = "anagram";
		String str2 = "nagaram";
		boolean flag = checkAnagram(str1, str2);
		System.out.println(flag);
	}

	public static boolean checkAnagramArray(String str1, String str2) {
		boolean status = false;
		char[] ch1 = str1.toLowerCase().toCharArray();
		char[] ch2 = str2.toLowerCase().toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		if(Arrays.equals(ch1, ch2)) {
			status = true;
		}
		return status;

	}

	public static boolean checkAnagram(String str1, String str2) {
		boolean status = false;
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					str2= str2.substring(0,j) + str2.substring(j+1);
				}
			}
		}

		if(str2.length() == 0) {
			status = true;
		}
		return status;

	}

}
