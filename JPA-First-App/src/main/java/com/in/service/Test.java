package com.in.service;

public class Test {
	public static void main(String[] args) {

		String s1 = new String("anwartech");
		String s2 = new String("anwartech");

		if (s1 == s2) {
			System.out.println("s1 == s2");
		} else {
			System.out.println("s1 != s2");
		}

		if (s1.equals(s2)) {
			System.out.println("Both strings are same");
		} else {
			System.out.println("Both strings are different");
		}

	}

}
